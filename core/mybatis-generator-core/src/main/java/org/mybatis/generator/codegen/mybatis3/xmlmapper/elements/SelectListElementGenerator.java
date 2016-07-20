package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public class SelectListElementGenerator extends AbstractXmlElementGenerator {
    public SelectListElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        FullyQualifiedJavaType parameterType = introspectedTable.getRules()
                .calculateAllFieldsClass();
        XmlElement answer = new XmlElement("select");

        answer.addAttribute(new Attribute("id", "selectList"));
        answer.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
        answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));
        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder("");
        sb.append("select ");
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
        sb.setLength(0);
        sb.append(" from ");
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        sb.append(" ").append(introspectedTable.calculateSqlShortTableName());

        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getWhereClauseElement());

        XmlElement orderElement = new XmlElement("if");
        orderElement.addAttribute(new Attribute("test", "order != null and order.colName != null and order.colName != ''"));
        orderElement.addElement(new TextElement("order by ${order.column}"));
        XmlElement descElement = new XmlElement("if");
        descElement.addAttribute(new Attribute("test", "order.desc"));
        descElement.addElement(new TextElement("desc"));
        orderElement.addElement(descElement);

        answer.addElement(orderElement);

        XmlElement limitElement = new XmlElement("if");
        limitElement.addAttribute(new Attribute("test", "offset > 0"));
        limitElement.addElement(new TextElement("limit #{count} offset #{offset}"));

        answer.addElement(limitElement);

        if (context.getPlugins()
                .sqlMapUpdateByExampleSelectiveElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }

    }
}
