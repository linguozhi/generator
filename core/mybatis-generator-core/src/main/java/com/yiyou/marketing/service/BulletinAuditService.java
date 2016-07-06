package com.yiyou.marketing.service;

import com.qw.ums.console.common.Order;
import com.yiyou.marketing.model.BulletinAudit;
import com.yiyou.marketing.persistence.BulletinAuditMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class BulletinAuditService {
    @Autowired
    private BulletinAuditMapper bulletinAuditMapper;

    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id, "id不能为空");
        return bulletinAuditMapper.deleteByPrimaryKey(id);
    }

    public int insert(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.insert(record);
    }

    public int insertSelective(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.insertSelective(record);
    }

    public BulletinAudit selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "查询对象不能为空");
        return bulletinAuditMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKeyWithBLOBs(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int selectTotal(BulletinAudit record) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.selectTotal(record);
    }

    public java.util.List<com.yiyou.marketing.model.BulletinAudit> selectList(BulletinAudit record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return bulletinAuditMapper.selectList(record, order, offset, count);
    }
}