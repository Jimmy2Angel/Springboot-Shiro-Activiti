package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.MatterTaskResult;
import indi.baojie.supervision.domain.MatterTaskResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatterTaskResultMapper {
    int countByExample(MatterTaskResultExample example);

    int deleteByExample(MatterTaskResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MatterTaskResult record);

    int insertSelective(MatterTaskResult record);

    List<MatterTaskResult> selectByExample(MatterTaskResultExample example);

    MatterTaskResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MatterTaskResult record, @Param("example") MatterTaskResultExample example);

    int updateByExample(@Param("record") MatterTaskResult record, @Param("example") MatterTaskResultExample example);

    int updateByPrimaryKeySelective(MatterTaskResult record);

    int updateByPrimaryKey(MatterTaskResult record);

    List<Integer> selectAllMatterId();

    MatterTaskResult getAllInfo(@Param("id") Integer matterTaskResultId);
}