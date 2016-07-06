package org.mybatis.generator.codegen.mybatis3.service.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public class SelectByPrimaryKeyMethodGenerator extends AbstractJavaServiceMethodGenerator {
    public SelectByPrimaryKeyMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();

        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(returnType);
        method.setName(introspectedTable.getSelectByPrimaryKeyStatementId());

        List<IntrospectedColumn> introspectedColumns = introspectedTable
                .getPrimaryKeyColumns();
        boolean annotate = introspectedColumns.size() > 1;
        if (annotate) {
            importedTypes.add(new FullyQualifiedJavaType(
                    "org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
        }

        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
            FullyQualifiedJavaType type = introspectedColumn
                    .getFullyQualifiedJavaType();
            importedTypes.add(type);
            Parameter parameter = new Parameter(type, introspectedColumn
                    .getJavaProperty());
            if (annotate) {
                sb.setLength(0);
                sb.append("@Param(\""); //$NON-NLS-1$
                sb.append(introspectedColumn.getJavaProperty());
                sb.append("\")"); //$NON-NLS-1$
                parameter.addAnnotation(sb.toString());
            }
            method.addParameter(parameter);
        }

        sb.setLength(0);
        sb.append("Assert.notNull(").append(introspectedColumns.get(0).getJavaProperty()).append(", \"查询对象不能为空\"").append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("return ").append(introspectedTable.getMyBatis3JavaMapperInstance())
                .append(".").append(introspectedTable.getSelectByPrimaryKeyStatementId())
                .append("(").append(introspectedColumns.get(0).getJavaProperty()).append(");");
        method.addBodyLine(sb.toString());

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
    }
}
