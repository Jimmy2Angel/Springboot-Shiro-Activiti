package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.Summary;
import indi.baojie.supervision.domain.SummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryMapper {
    int countByExample(SummaryExample example);

    int deleteByExample(SummaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Summary record);

    int insertSelective(Summary record);

    List<Summary> selectByExample(SummaryExample example);

    Summary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Summary record, @Param("example") SummaryExample example);

    int updateByExample(@Param("record") Summary record, @Param("example") SummaryExample example);

    int updateByPrimaryKeySelective(Summary record);

    int updateByPrimaryKey(Summary record);
}