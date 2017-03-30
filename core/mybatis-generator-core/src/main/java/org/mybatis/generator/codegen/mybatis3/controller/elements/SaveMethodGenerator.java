package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : linguozhi@52tt.com
 * @desc :
 * @date :  2017/1/19
 */
public class SaveMethodGenerator extends AbstractJavaControllerMethodGenerator {
    public SaveMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importTypes = new TreeSet<FullyQualifiedJavaType>();

        Method method = new Method();
        method.addAnnotation("@RequestMapping(\"/save\")");
        method.addAnnotation("@ResponseBody");

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewMapInstance();
        importTypes.add(returnType);
        method.setReturnType(returnType);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("save");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        importTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, introspectedTable.getModelBeanName()));

        //method body
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(introspectedTable.getServiceBeanName()).append(".");
        sb.append("insertSelective(").append(introspectedTable.getModelBeanName()).append(")")
                .append((" < 1 ) {"));
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("return ResponseHelper.buildErrorResult(\" 添加失败 \");");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("}");
        method.addBodyLine(sb.toString());

        method.addBodyLine("");
        sb.setLength(0);
        sb.append("return ResponseHelper.buildSuccessResult();");
        method.addBodyLine(sb.toString());

        topLevelClass.addImportedTypes(importTypes);
        topLevelClass.addMethod(method);
    }
}
