package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.dao.MatterAttachmentMapper;
import indi.baojie.supervision.service.MatterAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lollipop on 2017/8/1.
 */
@Service
@Transactional
public class MatterAttachmentServiceImpl implements MatterAttachmentService {

    @Autowired
    private MatterAttachmentMapper matterAttachmentMapper;
}
