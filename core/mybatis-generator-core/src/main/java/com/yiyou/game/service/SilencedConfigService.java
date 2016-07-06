package com.yiyou.game.service;

import com.yiyou.game.model.SilencedConfig;
import com.yiyou.game.persistence.SilencedConfigMapper;
import java.util.List;

public class SilencedConfigService {
    @Autowired
    private SilencedConfigMapper silencedConfigMapper;

    public int deleteByPrimaryKey(Long id) {
        Assert.notNull(id, "id不能为空");
        return silencedConfigMapper.deleteByPrimaryKey(id);
    }

    public int insert(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.insert(record);
    }

    public int insertSelective(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.insertSelective(record);
    }

    public SilencedConfig selectByPrimaryKey(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.selectByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKeyWithBLOBs(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int selectTotal(SilencedConfig record) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.selectTotal(record);
    }

    public java.util.List<com.yiyou.game.model.SilencedConfig> selectList(SilencedConfig record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return silencedConfigMapper.selectList(record);
    }
}