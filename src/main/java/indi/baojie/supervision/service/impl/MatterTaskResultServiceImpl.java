package indi.baojie.supervision.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import indi.baojie.supervision.dao.*;
import indi.baojie.supervision.domain.*;
import indi.baojie.supervision.service.MatterTaskResultService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Lollipop on 2017/7/11.
 */
@Service
public class MatterTaskResultServiceImpl implements MatterTaskResultService {

    @Autowired
    private MatterMapper matterMapper;
    @Autowired
    private MatterTaskResultMapper matterTaskResultMapper;
    @Autowired
    private MatterTaskMapper matterTaskMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 督查室登录显示待汇总的taskResult集合
     * @return
     */
    @Override
    public Map<Integer,List<MatterTaskResult>> selectTaskResultsOrderByMatterId() {
        Map<Integer,List<MatterTaskResult>> map = Maps.newHashMap();
        MatterExample matterExample = new MatterExample();
        matterExample.or().andStateEqualTo(3);
        List<Matter> matters = matterMapper.selectByExample(matterExample);
        for (Matter matter:matters) {
            MatterTaskResultExample example = new MatterTaskResultExample();
            example.or().andMatterIdEqualTo(matter.getId());
            List<MatterTaskResult> matterTaskResults = matterTaskResultMapper.selectByExample(example);
            List<Integer> resultIds = Lists.newArrayList();
            for (MatterTaskResult taskResult:matterTaskResults){
                Integer resultId = taskResult.getId();
                resultIds.add(resultId);
                MatterTask matterTask = matterTaskMapper.selectByPrimaryKey(taskResult.getTaskId());
                taskResult.setMatterTask(matterTask);
                FeedbackExample feedbackExample = new FeedbackExample();
                feedbackExample.or().andTaskResultIdEqualTo(resultId);
                List<Feedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
                taskResult.setFeedback((feedbacks!=null && feedbacks.size()>0)?feedbacks.get(0):null);
            }
            map.put(matter.getId(),matterTaskResults);
        }
        return (map!=null && map.size()>0)?map:Collections.<Integer, List<MatterTaskResult>>emptyMap();
    }

    /**
     * 根据taskName查询分别处于该阶段的taskResult集合
     * @return
     */
    @Override
    public List<MatterTaskResult> selectTaskResults(User user,String taskName) {
        List<MatterTaskResult> taskResults = Lists.newArrayList();
        List<Integer> taskResultIds = Lists.newArrayList();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(String.valueOf(user.getUnitId())).list();
        if ("结果判断".equals(taskName)) {
            for(Task task:tasks){
                //TODO "结果判断"
                if(taskName.equals(task.getName())){
                    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
                    if (processInstance==null) {
                        continue;
                    }
                    String matterTaskId = processInstance.getBusinessKey();
                    MatterTaskResultExample example = new MatterTaskResultExample();
                    example.or().andTaskIdEqualTo(Integer.valueOf(matterTaskId));
                    List<MatterTaskResult> results = matterTaskResultMapper.selectByExample(example);
                    if(results==null || results.size()==0) {
                        continue;
                    } else {
                        for (MatterTaskResult result:results) {
                            if(result.getReportTime() != null && !"1".equals(result.getRemark()) && !taskResultIds.contains(result.getId())){
                                taskResults.add(result);
                                taskResultIds.add(result.getId());
                            }
                        }
                    }
                }
            }
            for (MatterTaskResult taskResult:taskResults) {
                ReportExample example = new ReportExample();
                example.or().andTaskResultIdEqualTo(taskResult.getId());
                example.setOrderByClause("id desc");
                List<Report> reports = reportMapper.selectByExample(example);
                if (reports!=null && reports.size()>0) {
                    taskResult.setReport(reports.get(0));
                }
            }
        } else {
            for(Task task:tasks){
                //TODO "任务签收"、"信息反馈"、"结果上报"
                if(taskName.equals(task.getName())){
                    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
                    if (processInstance==null) {
                        continue;
                    }
                    String matterTaskId = processInstance.getBusinessKey();
                    MatterTaskResultExample example = new MatterTaskResultExample();
                    example.or().andTaskIdEqualTo(Integer.valueOf(matterTaskId)).andOrganizerIdEqualTo(user.getUnitId());
                    List<MatterTaskResult> results = matterTaskResultMapper.selectByExample(example);
                    if(results==null || results.size()==0) {
                        continue;
                    }
                    taskResults.add(results.get(0));
                }
            }
        }
        //往matterTaskResult的matterTask字段设值
        for(MatterTaskResult taskResult:taskResults){
            MatterTask matterTask = matterTaskMapper.selectByPrimaryKey(taskResult.getTaskId());
            Matter matter = matterMapper.selectByPrimaryKey(taskResult.getMatterId());
            taskResult.setMatterTask(matterTask);
            taskResult.setMatter(matter);
        }
        return taskResults;
    }

    /**
     * 根据id获取MatterTaskResult数据,包括matterTask属性
     * @param matterTaskResultId
     * @return
     */
    @Override
    public MatterTaskResult getAllInfo(Integer matterTaskResultId) {
        MatterTaskResult matterTaskResult = matterTaskResultMapper.getAllInfo(matterTaskResultId);
        ReportExample example = new ReportExample();
        example.or().andTaskResultIdEqualTo(matterTaskResultId);
        example.setOrderByClause("id desc");
        List<Report> reports = reportMapper.selectByExample(example);
        if (reports!=null && reports.size()>0) {
            matterTaskResult.setReport(reports.get(0));
        }
        return matterTaskResult;
    }

    /**
     * 查询当前用户所属机构相关的全部任务
     * @param orgCode
     * @return
     */
    @Override
    public List<MatterTaskResult> selectAllByOrganizerId(String orgCode) {
        MatterTaskResultExample example = new MatterTaskResultExample();
        example.or().andOrganizerIdEqualTo(Integer.valueOf(orgCode));
        List<MatterTaskResult> taskResults = matterTaskResultMapper.selectByExample(example);
        if (taskResults !=null && taskResults.size()>0) {
            return setState(taskResults);
        }
        return Collections.emptyList();
    }

    /**
     * 根据任务id查询各个承办机构的办理情况
     * @param matterTaskId
     * @return
     */
    @Override
    public List<MatterTaskResult> selectAllByTaskId(Integer matterTaskId) {
        MatterTaskResultExample example = new MatterTaskResultExample();
        example.or().andTaskIdEqualTo(matterTaskId);
        List<MatterTaskResult> taskResults = matterTaskResultMapper.selectByExample(example);
        List<MatterTaskResult> matterTaskResults = setState(taskResults);
        return matterTaskResults.size()>0?matterTaskResults:Collections.<MatterTaskResult>emptyList();
    }

    public List<MatterTaskResult> setState(List<MatterTaskResult> matterTaskResults){
        for (MatterTaskResult taskResult:matterTaskResults) {
            MatterTask matterTask = matterTaskMapper.selectByPrimaryKey(taskResult.getTaskId());
            Matter matter = matterMapper.selectByPrimaryKey(taskResult.getMatterId());
            taskResult.setMatter(matter);
            taskResult.setMatterTask(matterTask);
            if (taskResult.getSignTime() == null) { //未签收
                taskResult.setState(1);
            } else if (taskResult.getFeedbackTime() == null) {  //已签收
                taskResult.setState(2);
            } else if (taskResult.getReportTime() == null) {    //已反馈
                FeedbackExample feedbackExample = new FeedbackExample();
                feedbackExample.or().andTaskResultIdEqualTo(taskResult.getId());
                feedbackExample.setOrderByClause("id desc");
                taskResult.setFeedback(feedbackMapper.selectByExample(feedbackExample).get(0));
                taskResult.setState(3);
            } else if (!"1".equals(taskResult.getRemark())) {    //已上报
                FeedbackExample feedbackExample = new FeedbackExample();
                feedbackExample.or().andTaskResultIdEqualTo(taskResult.getId());
                feedbackExample.setOrderByClause("id desc");
                taskResult.setFeedback(feedbackMapper.selectByExample(feedbackExample).get(0));
                ReportExample reportExample = new ReportExample();
                reportExample.or().andTaskResultIdEqualTo(taskResult.getId());
                reportExample.setOrderByClause("id desc");
                taskResult.setReport(reportMapper.selectByExample(reportExample).get(0));
                taskResult.setState(4);
            } else if ("1".equals(taskResult.getRemark())) {    //
                FeedbackExample feedbackExample = new FeedbackExample();
                feedbackExample.or().andTaskResultIdEqualTo(taskResult.getId());
                feedbackExample.setOrderByClause("id desc");
                taskResult.setFeedback(feedbackMapper.selectByExample(feedbackExample).get(0));
                ReportExample reportExample = new ReportExample();
                reportExample.or().andTaskResultIdEqualTo(taskResult.getId());
                reportExample.setOrderByClause("id desc");
                taskResult.setReport(reportMapper.selectByExample(reportExample).get(0));
                taskResult.setState(5);
            }
        }
        return matterTaskResults;
    }
}
