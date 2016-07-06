package org.mybatis.generator.codegen.mybatis3.service.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public class SelectListMethodGenerator extends AbstractJavaServiceMethodGenerator {
    public SelectListMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importedTypes.add(returnType);
        importedTypes.add(listType);

        returnType.addTypeArgument(listType);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(returnType);
        method.setName("selectList");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        method.addParameter(new Parameter(parameterType, "record"));

        parameterType = new FullyQualifiedJavaType("Order");
        method.addParameter(new Parameter(parameterType, "order"));

        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset"));
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "count"));
        StringBuilder sb = new StringBuilder();
        sb.append("Assert.notNull(").append("record").append(", \"查询对象不能为空\"").append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("return ").append(introspectedTable.getMyBatis3JavaMapperInstance())
                .append(".").append("selectList")
                .append("(").append("record")
                .append(", order")
                .append(", offset")
                .append(", count").append(");");
        method.addBodyLine(sb.toString());

        importedTypes.add(parameterType);
        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
    }
}
