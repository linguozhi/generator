package org.mybatis.generator.codegen.mybatis3.service.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public class InsertMethodGenerator extends AbstractJavaServiceMethodGenerator {
    public InsertMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName(introspectedTable.getInsertStatementId());

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        method.addParameter(new Parameter(parameterType, "record"));
        StringBuilder sb = new StringBuilder();
        sb.append("Assert.notNull(").append("record").append(", \"查询对象不能为空\"").append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("return ").append(introspectedTable.getMyBatis3JavaMapperInstance())
                .append(".").append(introspectedTable.getInsertStatementId())
                .append("(").append("record").append(");");
        method.addBodyLine(sb.toString());

        importedTypes.add(parameterType);
        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
    }
}
