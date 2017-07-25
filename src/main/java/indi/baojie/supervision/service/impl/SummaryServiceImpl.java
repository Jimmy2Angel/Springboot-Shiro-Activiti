package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.dao.MatterMapper;
import indi.baojie.supervision.dao.SummaryMapper;
import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.Summary;
import indi.baojie.supervision.domain.SummaryExample;
import indi.baojie.supervision.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lollipop on 2017/7/17.
 */
@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private SummaryMapper summaryMapper;
    @Autowired
    private MatterMapper matterMapper;
    /**
     * 查询年度目标，关联查询报告
     * @return
     */
    @Override
    public List<Summary> selectSummaryWithMatter() {
        List<Summary> summaries = summaryMapper.selectByExample(new SummaryExample());

        for (Summary summary: summaries) {
            Integer matterId = summary.getMatterId();
            Matter matter = matterMapper.selectByPrimaryKey(matterId);
            summary.setMatter(matter);
            summaryMapper.updateByPrimaryKey(summary);
        }
        return summaries;
    }

    @Override
    public Summary selectByPrimaryKey(Integer summaryId) {
        return summaryMapper.selectByPrimaryKey(summaryId);
    }
}
