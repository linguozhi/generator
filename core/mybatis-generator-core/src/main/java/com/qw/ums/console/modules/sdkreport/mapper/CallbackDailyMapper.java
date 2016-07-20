package com.qw.ums.console.modules.sdkreport.mapper;

import com.qw.ums.console.common.Order;
import com.qw.ums.console.modules.sdkreport.entity.CallbackDaily;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CallbackDailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CallbackDaily record);

    int insertSelective(CallbackDaily record);

    CallbackDaily selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CallbackDaily record);

    int updateByPrimaryKey(CallbackDaily record);

    int selectTotal(@Param("record") CallbackDaily record);

    java.util.List<com.qw.ums.console.modules.sdkreport.entity.CallbackDaily> selectList(@Param("record") CallbackDaily record, @Param("order") Order order, @Param("offset") int offset, @Param("count") int count);
}