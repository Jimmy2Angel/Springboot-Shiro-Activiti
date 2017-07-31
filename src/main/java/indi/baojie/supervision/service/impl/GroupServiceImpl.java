package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.dao.GroupMapper;
import indi.baojie.supervision.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lollipop on 2017/7/31.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;


    @Override
    public List selectAllGroup() {
        return groupMapper.selectAllGroup();
    }
}
