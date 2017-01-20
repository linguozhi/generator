package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : linguozhi@52tt.com
 * @desc :
 * @date :  2017/1/19
 */
public class UpdateMethodGenerator extends AbstractJavaControllerMethodGenerator {
    public UpdateMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importTypes = new TreeSet<FullyQualifiedJavaType>();

        Method method = new Method();

        method.addAnnotation("@RequestMapping(\"/update\")");
        method.addAnnotation("@ResponseBody");
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewMapInstance();
        importTypes.add(returnType);
        method.setReturnType(returnType);
        method.setName("update");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        importTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, introspectedTable.getModelBeanName()));

        // method body
        StringBuilder sb = new StringBuilder();
        sb.append("Assert.notNull(\"" + introspectedTable.getModelBeanName() + ".getId() , \"id not null\"); ");
        method.addBodyLine(sb.toString());
        method.addBodyLine("");

        sb.setLength(0);
        sb.append("if( ").append(introspectedTable.getServiceBeanName()).append(".").append("updateByPrimaryKeySelective");
        sb.append("(").append(introspectedTable.getModelBeanName()).append(")").append(" < 1 ) {");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("return ResponseHelper.buildErrorResult(\"更新失败\");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("}");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        method.addBodyLine("");
        sb.append("return ResponseHelper.buildSuccessResult()");
        method.addBodyLine(sb.toString());

        topLevelClass.addImportedTypes(importTypes);
        topLevelClass.addMethod(method);
    }
}
