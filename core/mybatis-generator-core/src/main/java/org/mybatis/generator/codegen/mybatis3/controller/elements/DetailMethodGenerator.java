package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : linguozhi@52tt.com
 * @desc : 详情生成器
 * @date :  2017/1/20
 */
public class DetailMethodGenerator extends AbstractJavaControllerMethodGenerator {
    public DetailMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importTypes = new TreeSet<FullyQualifiedJavaType>();

        Method method = new Method();
        method.addAnnotation("@RequestMapping(\"/detail\")");
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getStringInstance();
        importTypes.add(returnType);
        method.setReturnType(returnType);
        method.setName("detail");


        // primary key, eg:id
        FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
        importTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName()));

        // model
        parameterType = new FullyQualifiedJavaType("org.springframework.ui.Model");
        importTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, "model"));

        // method body
        StringBuilder sb = new StringBuilder();
        sb.append(introspectedTable.getRules().calculateAllFieldsClass()).append(" ").append(introspectedTable.getModelBeanName());
        sb.append(" = ").append(introspectedTable.getServiceBeanName()).append(".").append("selectByPrimaryKey(").append(introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty());
        sb.append(");");

        method.addBodyLine(sb.toString());
        sb.setLength(0);
        method.addBodyLine("");

        sb.append("if (").append(introspectedTable.getModelBeanName()).append(" == ").append("null").append(") {");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("return ResponseHelper.buildErrorResult(\"对象不存在\");");
        method.addBodyLine(sb.toString());
        sb.append("}");
        method.addBodyLine(sb.toString());
        method.addBodyLine("");

        sb.setLength(0);

        sb.append("model.addAttribute(\"").append(introspectedTable.getModelBeanName()).append("\", ").append(introspectedTable.getModelBeanName()).append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("return ").append(introspectedTable.getMapperBeanName()).append("/").append("detail;");
        method.addBodyLine(sb.toString());

        topLevelClass.addImportedTypes(importTypes);
        topLevelClass.addMethod(method);
    }
}
