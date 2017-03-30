package org.mybatis.generator.codegen.mybatis3.controller;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.controller.elements.*;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/27
 */
public class BaseControllerGenerator extends AbstractJavaGenerator {
    @Override
    public List<CompilationUnit> getCompilationUnits() {
        progressCallback.startTask(getString("Progress.20", introspectedTable.getFullyQualifiedTable().toString()));


        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getMybatis3JavaControllerType());
        TopLevelClass topLevelClass = new TopLevelClass(type);
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(topLevelClass);

        // anno
        topLevelClass.addAnnotation("@Controller");
        topLevelClass.addAnnotation("@RequestMapping(\"" + introspectedTable.getModelBeanName() + "\")");

        // importTypes;
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.web.bind.annotation.RequestMapping"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.Autowired"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.web.bind.annotation.ResponseBody"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Controller"));

        //fields
        Field field = new Field();
        field.setVisibility(JavaVisibility.PRIVATE);
        FullyQualifiedJavaType serviceType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaServiceType());
        field.setType(serviceType);
        topLevelClass.addImportedType(serviceType);
        field.setName(introspectedTable.getServiceBeanName());
        field.addAnnotation("@Autowired");

        topLevelClass.addField(field);
        // methods
        addIndexMethod(topLevelClass);
        addGetListMethod(topLevelClass);
        addUpdateMethod(topLevelClass);
        addSaveMethod(topLevelClass);
        addDetailMethod(topLevelClass);
        addDeleteMethod(topLevelClass);

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        answer.add(topLevelClass);
        return answer;
    }

    private void addDetailMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new DetailMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addGetListMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new GetListMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addUpdateMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new UpdateMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addSaveMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new SaveMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addDeleteMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new DeleteMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addIndexMethod(TopLevelClass topLevelClass) {
        AbstractJavaControllerMethodGenerator methodGenerator = new IndexMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }
    private void initializeAndExecuteGenerator(AbstractJavaControllerMethodGenerator methodGenerator, TopLevelClass topLevelClass) {
        methodGenerator.setContext(context);
        methodGenerator.setIntrospectedTable(introspectedTable);
        methodGenerator.setProgressCallback(progressCallback);
        methodGenerator.setWarnings(warnings);
        methodGenerator.addClassElements(topLevelClass);
    }


}
