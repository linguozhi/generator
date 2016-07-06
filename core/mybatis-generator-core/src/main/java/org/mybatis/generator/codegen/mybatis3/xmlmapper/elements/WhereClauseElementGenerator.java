package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * @desc: where条件 构造器
 * @author:linguozhi@52tt.com
 * @date: 2016/6/22
 */
public class WhereClauseElementGenerator extends AbstractXmlElementGenerator{
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql");

        answer.addAttribute(new Attribute("id", introspectedTable.getWhereClauseId()));

        StringBuilder sb = new StringBuilder("");
        sb.append(" where 1=1 ");
        answer.addElement(new TextElement(sb.toString()));

        for(IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty("record.")); //$NON-NLS-1$
            sb.append(" != null"); //$NON-NLS-1$
            // string 类型加空字符串判断
            if(introspectedColumn.isStringColumn()) {
                sb.append(" and ").append(introspectedColumn.getJavaProperty("record."));
                sb.append(" != ''");
            }
            isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
            answer.addElement(isNotNullElement);

            sb.setLength(0);
            sb.append("and ");
            sb.append(introspectedTable.calculateSqlShortTableName()).append(".");
            sb.append(MyBatis3FormattingUtilities
                    .getAliasedEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities.getParameterClause(
                    introspectedColumn, "record.")); //$NON-NLS-1$

            isNotNullElement.addElement(new TextElement(sb.toString()));
        }

        parentElement.addElement(answer);
    }
}
