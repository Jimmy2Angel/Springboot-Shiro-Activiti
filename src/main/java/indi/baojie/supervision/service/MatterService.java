package indi.baojie.supervision.service;

import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.MatterExample;
import indi.baojie.supervision.domain.MatterTask;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.domain.form.MatterTaskForm;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Lollipop on 2017/5/10.
 */
public interface MatterService {
    List<Matter> selectAll();
    JsonResult addMatter(User user, Matter matter, MultipartFile file, HttpServletRequest request, JsonResult jsonResult);

    Matter selectById(Integer matterId);

    List<Matter> getMaterAllInfo(Integer id);

    boolean deleteByIds(List<Integer> idList);

    boolean updateByExample(Matter matter, MatterExample matterExample);

    JsonResult updateByPrimaryKey(User user, Matter matter, MultipartFile file, HttpServletRequest request, JsonResult jsonResult);

//    List<ScheduleInfo> selectSchedule(Integer transactionResultId);

//    List<String> handleYears(List<ScheduleInfo> scheduleInfos);

    boolean doSign(User user, Integer taskResultId);

    JsonResult doFeedback(User user, Integer matterTaskResultId, String feedback, MultipartFile file, HttpServletRequest request);

    List<Matter> selectDecomposeMatters();

    boolean doDecompose(Integer matterId, MatterTaskForm matterTaskForm);

    List<Matter> getAllSummaryMatter();

    JsonResult doReport(User user, Integer taskResultId, String reportContent, MultipartFile file, HttpServletRequest request);

    JsonResult doSummary(User user, Integer matterId, String summary, MultipartFile file, HttpServletRequest request);

    boolean doJudge(User user, String type, Integer matterTaskResultId, String unPassReason);

    List<MatterTask> getTaskListByMatterId(Integer matterId);
}
