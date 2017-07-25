package indi.baojie.supervision.service;


import indi.baojie.supervision.domain.Summary;
import java.util.List;

/**
 * Created by Lollipop on 2017/7/17.
 */
public interface SummaryService {
    List<Summary> selectSummaryWithMatter();

    Summary selectByPrimaryKey(Integer summaryId);
}
