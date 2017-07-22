package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.MatterAttachment;
import indi.baojie.supervision.domain.MatterAttachmentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MatterAttachmentMapper {
    int countByExample(MatterAttachmentExample example);

    int deleteByExample(MatterAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MatterAttachment record);

    int insertSelective(MatterAttachment record);

    List<MatterAttachment> selectByExample(MatterAttachmentExample example);

    MatterAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MatterAttachment record, @Param("example") MatterAttachmentExample example);

    int updateByExample(@Param("record") MatterAttachment record, @Param("example") MatterAttachmentExample example);

    int updateByPrimaryKeySelective(MatterAttachment record);

    int updateByPrimaryKey(MatterAttachment record);
}