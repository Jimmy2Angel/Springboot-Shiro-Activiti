package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.MatterTask;
import indi.baojie.supervision.domain.MatterTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MatterTaskMapper {
    int countByExample(MatterTaskExample example);

    int deleteByExample(MatterTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MatterTask record);

    int insertSelective(MatterTask record);

    List<MatterTask> selectByExample(MatterTaskExample example);

    MatterTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MatterTask record, @Param("example") MatterTaskExample example);

    int updateByExample(@Param("record") MatterTask record, @Param("example") MatterTaskExample example);

    int updateByPrimaryKeySelective(MatterTask record);

    int updateByPrimaryKey(MatterTask record);
}