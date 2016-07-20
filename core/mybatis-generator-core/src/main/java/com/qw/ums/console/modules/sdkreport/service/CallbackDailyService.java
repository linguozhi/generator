package com.qw.ums.console.modules.sdkreport.service;

import com.qw.ums.console.common.Order;
import com.qw.ums.console.modules.sdkreport.entity.CallbackDaily;
import com.qw.ums.console.modules.sdkreport.mapper.CallbackDailyMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class CallbackDailyService {
    @Autowired
    private CallbackDailyMapper callbackDailyMapper;

    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id, "id不能为空");
        return callbackDailyMapper.deleteByPrimaryKey(id);
    }

    public int insert(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.insert(record);
    }

    public int insertSelective(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.insertSelective(record);
    }

    public CallbackDaily selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "查询对象不能为空");
        return callbackDailyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKeyWithBLOBs(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int selectTotal(CallbackDaily record) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.selectTotal(record);
    }

    public java.util.List<com.qw.ums.console.modules.sdkreport.entity.CallbackDaily> selectList(CallbackDaily record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return callbackDailyMapper.selectList(record, order, offset, count);
    }
}