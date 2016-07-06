package org.mybatis.generator.codegen.mybatis3.controller.elements;

import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.AbstractGenerator;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public abstract class AbstractJavaControllerMethodGenerator extends AbstractGenerator{
    public AbstractJavaControllerMethodGenerator() {
        super();
    }

    public abstract void addClassElements(TopLevelClass topLevelClass);
}
