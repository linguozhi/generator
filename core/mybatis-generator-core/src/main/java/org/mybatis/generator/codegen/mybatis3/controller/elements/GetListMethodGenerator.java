package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/30
 */
public class GetListMethodGenerator extends AbstractJavaControllerMethodGenerator {

    public GetListMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();

        Method method = new Method();

        method.addAnnotation("@RequestMapping(\"/getList\")");
        method.addAnnotation("@ResponseBody");
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("com.qw.ums.console.common.DataTable");
        importedTypes.add(returnType);
        method.setReturnType(returnType);
        method.setName("getList");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        importedTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, introspectedTable.getModelBeanName()));
        // param order
        parameterType = new FullyQualifiedJavaType("Order");
        method.addParameter(new Parameter(parameterType, "order"));

        // param start
        parameterType = FullyQualifiedJavaType.getIntInstance();
        method.addParameter(new Parameter(parameterType, "start"));

        // param length
        parameterType = FullyQualifiedJavaType.getIntInstance();
        method.addParameter(new Parameter(parameterType, "length"));

        // param draw
        parameterType = FullyQualifiedJavaType.getIntInstance();
        method.addParameter(new Parameter(parameterType, "draw"));

        StringBuilder sb = new StringBuilder();
        String serviceBeanName = introspectedTable.getServiceBeanName();
        sb.append("int total = ");
        sb.append(serviceBeanName);
        sb.append(".");
        sb.append("selectTotal(");
        sb.append(introspectedTable.getModelBeanName());
        sb.append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("List<").append(introspectedTable.getRules().calculateAllFieldsClass().getShortName());
        sb.append(">");
        sb.append(" list = null;");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("if(total > 0) {");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("list = ").append(introspectedTable.getServiceBeanName());
        sb.append(".").append("selectList(");
        sb.append(introspectedTable.getModelBeanName());
        sb.append(", order, start, length");
        sb.append(");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("}");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        method.addBodyLine("");
        sb.append("return ResponseHelper.buildTable(draw, total, list);");
        method.addBodyLine(sb.toString());

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
    }
}
