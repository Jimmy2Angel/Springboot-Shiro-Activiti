package indi.baojie.supervision.service;

import indi.baojie.supervision.domain.MatterTaskResult;
import indi.baojie.supervision.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Lollipop on 2017/7/11.
 */
public interface MatterTaskResultService {
    Map<Integer,List<MatterTaskResult>> selectTaskResultsOrderByMatterId();

    List<MatterTaskResult> selectTaskResults(User user, String taskName);

    MatterTaskResult getAllInfo(Integer matterTaskResultId);

    List<MatterTaskResult> selectAllByOrganizerId(String orgCode);

    List<MatterTaskResult> selectAllByTaskId(Integer matterTaskId);
}
