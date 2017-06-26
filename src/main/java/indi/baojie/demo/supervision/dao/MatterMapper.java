package indi.baojie.demo.supervision.dao;

import indi.baojie.demo.supervision.domain.Matter;
import indi.baojie.demo.supervision.domain.MatterExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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