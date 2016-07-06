package com.yiyou.marketing.persistence;

import com.qw.ums.console.common.Order;
import com.yiyou.marketing.model.BulletinAudit;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BulletinAuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BulletinAudit record);

    int insertSelective(BulletinAudit record);

    BulletinAudit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BulletinAudit record);

    int updateByPrimaryKey(BulletinAudit record);

    int selectTotal(@Param("record") BulletinAudit record);

    java.util.List<com.yiyou.marketing.model.BulletinAudit> selectList(@Param("record") BulletinAudit record, @Param("order") Order order, @Param("offset") int offset, @Param("count") int count);
}