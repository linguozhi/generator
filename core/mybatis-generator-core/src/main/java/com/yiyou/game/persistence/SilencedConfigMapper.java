package com.yiyou.game.persistence;

import com.yiyou.game.model.SilencedConfig;
import com.yiyou.game.model.SilencedConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SilencedConfigMapper {
    int countByExample(SilencedConfigExample example);

    int deleteByExample(SilencedConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SilencedConfig record);

    int insertSelective(SilencedConfig record);

    List<SilencedConfig> selectByExampleWithBLOBs(SilencedConfigExample example);

    List<SilencedConfig> selectByExample(SilencedConfigExample example);

    SilencedConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SilencedConfig record, @Param("example") SilencedConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") SilencedConfig record, @Param("example") SilencedConfigExample example);

    int updateByExample(@Param("record") SilencedConfig record, @Param("example") SilencedConfigExample example);

    int updateByPrimaryKeySelective(SilencedConfig record);

    int updateByPrimaryKeyWithBLOBs(SilencedConfig record);

    int updateByPrimaryKey(SilencedConfig record);

    int selectTotal(@Param("record") SilencedConfig record);

    List<SilencedConfig> selectList(@Param("record") SilencedConfig record, @Param("order") String order, @Param("offset") int offset, @Param("count") int count);
}