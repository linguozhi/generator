package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/27
 */
public class IndexMethodGenerator extends AbstractJavaControllerMethodGenerator {
    public IndexMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.setName("index");
        method.addAnnotation("@RequestMapping(\"/index\")");


        StringBuilder sb = new StringBuilder();
        sb.append("return \"index.html\"");
        method.addBodyLine(sb.toString());

        topLevelClass.addMethod(method);
    }
}
