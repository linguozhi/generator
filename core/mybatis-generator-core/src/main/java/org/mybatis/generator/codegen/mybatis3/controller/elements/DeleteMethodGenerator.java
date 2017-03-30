package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : linguozhi@52tt.com
 * @desc : 删除方法
 * @date :  2017/1/22
 */
public class DeleteMethodGenerator extends AbstractJavaControllerMethodGenerator {
    public DeleteMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Set<FullyQualifiedJavaType> importTypes = new TreeSet<FullyQualifiedJavaType>();

        Method method = new Method();

        method.addAnnotation("@RequestMapping(\"/delete\")");
        method.addAnnotation("@ResponseBody");
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewMapInstance();
        importTypes.add(returnType);
        method.setReturnType(returnType);
        method.setName("delete");

        FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
        importTypes.add(parameterType);

        method.addParameter(new Parameter(parameterType, introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName()));

        // method body
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(introspectedTable.getServiceBeanName()).append(".delete").append("(").append(introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty())
                .append(") < 1").append(") {");
        method.addBodyLine(sb.toString());
        sb.setLength(0);
        sb.append("return ResponseHelper.buildErrorResult(\"删除失败\")");

        method.addBodyLine(sb.toString());
        method.addBodyLine("}");
        method.addBodyLine("");

        sb.setLength(0);
        sb.append("return ResponseHelper.buildSuccessResult(\"删除成功\")");
        method.addBodyLine(sb.toString());

        topLevelClass.addImportedTypes(importTypes);
        topLevelClass.addMethod(method);
    }
}
