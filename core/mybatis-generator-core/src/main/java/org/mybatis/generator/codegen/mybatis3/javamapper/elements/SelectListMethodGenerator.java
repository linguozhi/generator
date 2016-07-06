package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/25
 */
public class SelectListMethodGenerator extends AbstractJavaMapperMethodGenerator {
    public SelectListMethodGenerator() {
        super();
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        returnType.addTypeArgument(listType);
        importedTypes.add(returnType);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(returnType);
        method.setName("selectList");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        method.addParameter(new Parameter(parameterType, "record", "@Param(\"record\")"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType("Order"), "order", "@Param(\"order\")"));
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset", "@Param(\"offset\")"));
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "count", "@Param(\"count\")"));
        importedTypes.add(parameterType);

        importedTypes.add(new FullyQualifiedJavaType(
                "org.apache.ibatis.annotations.Param")); //$NON-NLS-1$


        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }

    private void addMapperAnnotations(Interface interfaze, Method method) {
        return;
    }
}
