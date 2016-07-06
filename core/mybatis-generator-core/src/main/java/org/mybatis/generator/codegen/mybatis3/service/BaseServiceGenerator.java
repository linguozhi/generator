package org.mybatis.generator.codegen.mybatis3.service;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.AbstractGenerator;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.service.elements.*;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * @desc: 基础service生成类
 * @author:linguozhi@52tt.com
 * @date: 2016/5/24
 */
public class BaseServiceGenerator extends AbstractJavaGenerator {
    public BaseServiceGenerator() {super();}

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        progressCallback.startTask(getString("Progress.19", introspectedTable.getFullyQualifiedTable().toString()));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getMyBatis3JavaServiceType());

        TopLevelClass topLevelClass = new TopLevelClass(type);
        topLevelClass.addAnnotation("@Service");
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(topLevelClass);

        FullyQualifiedJavaType superClass = getSuperClass();
        if (superClass != null) {
            topLevelClass.setSuperClass(superClass);
            topLevelClass.addImportedType(superClass);
        }

        FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
        topLevelClass.addImportedType(parameterType);
        // add spring java type
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.util.Assert"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("com.qw.ums.console.common.Order"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.Autowired"));


        StringBuilder sb = new StringBuilder();
        sb.append("@Autowired");

        Field mapperField = new Field();
        mapperField.addAnnotation(sb.toString());
            mapperField.setVisibility(JavaVisibility.PRIVATE);
        mapperField.setType(parameterType);
        mapperField.setName(introspectedTable.getMapperBeanName());

        topLevelClass.addField(mapperField);


        addDeleteByPrimaryKeyMethod(topLevelClass);
        addInsertMethod(topLevelClass);
        addInsertSelectiveMethod(topLevelClass);
        addSelectByPrimaryKeyMethod(topLevelClass);
        addUpdateByPrimaryKeySelectiveMethod(topLevelClass);
        addUpdateByPrimaryKeyWithBLOBsMethod(topLevelClass);
        addUpdateByPrimaryKeyWithoutBLOBsMethod(topLevelClass);
        addSelectTotalMethod(topLevelClass);
        addSelectListMehthod(topLevelClass);

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        answer.add(topLevelClass);
        List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }

        return answer;
    }

    private void addSelectListMehthod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new SelectListMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addSelectTotalMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new SelectTotalMetthodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addDeleteByPrimaryKeyMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new DeleteByPrimaryKeyMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }


    private void addInsertMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new InsertMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addInsertSelectiveMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new InsertSelectiveMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addSelectByPrimaryKeyMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new SelectByPrimaryKeyMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addUpdateByPrimaryKeySelectiveMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new UpdateByPrimarKeySelectiveMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addUpdateByPrimaryKeyWithBLOBsMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithBLOBsMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private void addUpdateByPrimaryKeyWithoutBLOBsMethod(TopLevelClass topLevelClass) {
        AbstractJavaServiceMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithoutBLOBsMethod();
        initializeAndExecuteGenerator(methodGenerator, topLevelClass);
    }

    private FullyQualifiedJavaType getSuperClass() {
        FullyQualifiedJavaType superClass;
        String rootClass = getRootClass();
        if (rootClass != null) {
            superClass = new FullyQualifiedJavaType(rootClass);
        } else {
            superClass = null;
        }

        return superClass;
    }

    private void initializeAndExecuteGenerator(AbstractJavaServiceMethodGenerator methodGenerator, TopLevelClass topLevelClass) {
        methodGenerator.setContext(context);
        methodGenerator.setIntrospectedTable(introspectedTable);
        methodGenerator.setProgressCallback(progressCallback);
        methodGenerator.setWarnings(warnings);
        methodGenerator.addClassElements(topLevelClass);
    }

    public List<CompilationUnit> getExtraCompilationUnits() {
        return null;
    }
}
