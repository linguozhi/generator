package com.qw.ums.console.modules.sdkreport.mapper;

import com.qw.ums.console.common.Order;
import com.qw.ums.console.modules.sdkreport.model.SubscribeStatMonthly;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubscribeStatMonthlyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubscribeStatMonthly record);

    int insertSelective(SubscribeStatMonthly record);

    SubscribeStatMonthly selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubscribeStatMonthly record);

    int updateByPrimaryKey(SubscribeStatMonthly record);

    int selectTotal(@Param("record") SubscribeStatMonthly record);

    java.util.List<com.qw.ums.console.modules.sdkreport.model.SubscribeStatMonthly> selectList(@Param("record") SubscribeStatMonthly record, @Param("order") Order order, @Param("offset") int offset, @Param("count") int count);
}