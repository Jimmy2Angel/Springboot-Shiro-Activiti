package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.MatterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}