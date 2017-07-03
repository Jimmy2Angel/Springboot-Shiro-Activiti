package indi.baojie.demo.supervision.service.impl;

import indi.baojie.demo.supervision.dao.MatterMapper;
import indi.baojie.demo.supervision.domain.Matter;
import indi.baojie.demo.supervision.service.MatterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lollipop on 2017/7/3.
 */
public class MatterServiceImpl implements MatterService {

    @Autowired
    private MatterMapper matterMapper;

    /**
     * 查询办事信息，如果id为null，则返回所有
     * @param id
     * @return
     */
    public List<Matter> getMaterAllInfo(Integer id){


        List<Matter> matters = matterMapper.getMaterAllInfo(id);
//        for(Matter matter:matters){
//            MatterAttachmentExample matterAttachmentExample = new MatterAttachmentExample();
//            matterAttachmentExample.or().andMatterIdEqualTo(matter.getId());
//            matterAttachmentExample.setOrderByClause("id desc");
//            List<MatterAttachment> matterAttachments = matterAttachmentMapper.selectByExample(matterAttachmentExample);
//            matter.setMatterAttachments(matterAttachments);
//        }
        return matters;
    }
}
