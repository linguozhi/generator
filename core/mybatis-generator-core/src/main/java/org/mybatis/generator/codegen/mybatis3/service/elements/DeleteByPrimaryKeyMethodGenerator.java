package org.mybatis.generator.codegen.mybatis3.service.elements;

import org.mybatis.generator.api.dom.java.*;

/**
 * @desc:
 * @author:linguozhi@52tt.com
 * @date: 2016/5/26
 */
public class DeleteByPrimaryKeyMethodGenerator extends AbstractJavaServiceMethodGenerator {
    public DeleteByPrimaryKeyMethodGenerator() {
        super();
    }

    @Override
    public void addClassElements(TopLevelClass topLevelClass) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName(introspectedTable.getDeleteByPrimaryKeyStatementId());
        method.addParameter(new Parameter(introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType(), introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty()));
        topLevelClass.addImportedType(introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType());
        StringBuilder sb = new StringBuilder();
        sb.append("Assert.notNull(").append(introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty()).append(",\"id不能为空\")");
        method.addBodyLine(sb.toString());
        sb.setLength(0);

        sb.append("return ").append(introspectedTable.getMyBatis3JavaMapperInstance())
                .append(".").append(introspectedTable.getDeleteByPrimaryKeyStatementId())
                .append("(").append("id").append(")").append(";");
        method.addBodyLine(sb.toString());

        topLevelClass.addMethod(method);
    }


}
