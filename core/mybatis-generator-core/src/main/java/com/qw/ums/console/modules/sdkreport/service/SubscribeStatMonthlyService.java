package com.qw.ums.console.modules.sdkreport.service;

import com.qw.ums.console.common.Order;
import com.qw.ums.console.modules.sdkreport.mapper.SubscribeStatMonthlyMapper;
import com.qw.ums.console.modules.sdkreport.model.SubscribeStatMonthly;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SubscribeStatMonthlyService {
    @Autowired
    private SubscribeStatMonthlyMapper subscribeStatMonthlyMapper;

    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id, "id不能为空");
        return subscribeStatMonthlyMapper.deleteByPrimaryKey(id);
    }

    public int insert(SubscribeStatMonthly record) {
        Assert.notNull(record, "查询对象不能为空");
        return subscribeStatMonthlyMapper.insert(record);
    }

    public int insertSelective(SubscribeStatMonthly record) {
        Assert.notNull(record, "查询对象不能为空");
        return subscribeStatMonthlyMapper.insertSelective(record);
    }

    public SubscribeStatMonthly selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "查询对象不能为空");
        return subscribeStatMonthlyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(SubscribeStatMonthly record) {
        Assert.notNull(record, "查询对象不能为空");
        return subscribeStatMonthlyMapper.updateByPrimaryKeySelective(record);
    }

    public int selectTotal(SubscribeStatMonthly record) {
        Assert.notNull(record, "查询对象不能为空");
        return subscribeStatMonthlyMapper.selectTotal(record);
    }

    public java.util.List<com.qw.ums.console.modules.sdkreport.model.SubscribeStatMonthly> selectList(SubscribeStatMonthly record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return subscribeStatMonthlyMapper.selectList(record, order, offset, count);
    }
}