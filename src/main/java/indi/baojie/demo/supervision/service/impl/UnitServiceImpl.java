package indi.baojie.demo.supervision.service.impl;

import indi.baojie.demo.supervision.dao.UnitMapper;
import indi.baojie.demo.supervision.domain.Unit;
import indi.baojie.demo.supervision.domain.UnitExample;
import indi.baojie.demo.supervision.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lollipop on 2017/6/26.
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<Unit> selectAll() {
        return unitMapper.selectByExample(new UnitExample());
    }
}
