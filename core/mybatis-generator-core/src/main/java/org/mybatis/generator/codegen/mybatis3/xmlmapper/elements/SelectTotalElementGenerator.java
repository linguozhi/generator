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
 * @date: 2016/5/25
 */
public class SelectTotalElementGenerator extends AbstractXmlElementGenerator {
    public SelectTotalElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        FullyQualifiedJavaType parameterType = introspectedTable.getRules()
                .calculateAllFieldsClass();
        XmlElement answer = new XmlElement("select");

        answer.addAttribute(new Attribute("id", "selectTotal"));
        answer.addAttribute(new Attribute("resultType", "java.lang.Integer"));
        answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));
        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder("");
        sb.append("select count(*) from ");
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        sb.append(" ").append(introspectedTable.calculateSqlShortTableName());

        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getWhereClauseElement());

        if (context.getPlugins()
                .sqlMapUpdateByExampleSelectiveElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
