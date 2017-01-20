package com.dazi.core.modules.column.service;

import com.dazi.core.modules.column.mapper.ColumnMapper;
import com.dazi.core.modules.column.model.Column;
import com.qw.ums.console.common.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ColumnService {
    @Autowired
    private ColumnMapper columnMapper;

    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id,"id不能为空")
        return columnMapper.deleteByPrimaryKey(id);
    }

    public int insert(Column record) {
        Assert.notNull(record, "查询对象不能为空");
        return columnMapper.insert(record);
    }

    public int insertSelective(Column record) {
        Assert.notNull(record, "查询对象不能为空");
        return columnMapper.insertSelective(record);
    }

    public Column selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "查询对象不能为空");
        return columnMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Column record) {
        Assert.notNull(record, "查询对象不能为空");
        return columnMapper.updateByPrimaryKeySelective(record);
    }

    public int selectTotal(Column record) {
        Assert.notNull(record, "查询对象不能为空");
        return columnMapper.selectTotal(record);
    }

    public java.util.List<com.dazi.core.modules.column.model.Column> selectList(Column record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return columnMapper.selectList(record, order, offset, count);
    }
}