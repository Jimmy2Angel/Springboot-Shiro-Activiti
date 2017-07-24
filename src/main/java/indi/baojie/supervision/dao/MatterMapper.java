package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.MatterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatterMapper {
    int countByExample(MatterExample example);

    int deleteByExample(MatterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Matter record);

    int insertSelective(Matter record);

    List<Matter> selectByExample(MatterExample example);

    Matter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Matter record, @Param("example") MatterExample example);

    int updateByExample(@Param("record") Matter record, @Param("example") MatterExample example);

    int updateByPrimaryKeySelective(Matter record);

    int updateByPrimaryKey(Matter record);

    List<Matter> getMaterAllInfo(@Param("id") Integer id);

    int deleteByIds(@Param("idList") List<Integer> idList);


    int updateActInsIdById(@Param("id") Integer id, @Param("processInstanceId") String processInstanceId);

    List<Matter> selectDecomposeMatters();
}