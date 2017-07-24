package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.Report;
import indi.baojie.supervision.domain.ReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    int countByExample(ReportExample example);

    int deleteByExample(ReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Report record);

    int insertSelective(Report record);

    List<Report> selectByExample(ReportExample example);

    Report selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
}