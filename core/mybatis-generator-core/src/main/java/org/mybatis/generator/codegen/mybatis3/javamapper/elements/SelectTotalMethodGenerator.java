package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/25
 */
public class SelectTotalMethodGenerator extends AbstractJavaMapperMethodGenerator {

    public SelectTotalMethodGenerator() {super();}

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("selectTotal");

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        method.addParameter(new Parameter(parameterType, "record", "@Param(\"record\")"));
        importedTypes.add(parameterType);

        importedTypes.add(new FullyQualifiedJavaType(
                "org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
        importedTypes.add(new FullyQualifiedJavaType(
                "com.qw.ums.console.common.Order"));

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
        return;
    }

}
