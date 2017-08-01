package indi.baojie.supervision.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.dao.*;
import indi.baojie.supervision.domain.*;
import indi.baojie.supervision.domain.form.MatterTaskForm;
import indi.baojie.supervision.service.MatterService;
import indi.baojie.supervision.utils.DateUtil;
import indi.baojie.supervision.utils.FileUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lollipop on 2017/5/10.
 */
@Service
@Transactional
public class MatterServiceImpl implements MatterService {

    @Autowired
    private MatterMapper matterMapper;
    @Autowired
    private SummaryMapper summaryMapper;
    @Autowired
    private MatterTaskMapper matterTaskMapper;
    @Autowired
    private MatterAttachmentMapper matterAttachmentMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private MatterTaskResultMapper matterTaskResultMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    protected RepositoryService repositoryService;

    /**
     * 新增办件处理
     */
    @Override
    @Transactional(readOnly = false)
    public JsonResult addMatter(User user, Matter matter, MultipartFile file, HttpServletRequest request, JsonResult jsonResult) {
        matter.setCreateUserId(user.getUserId());
        matter.setCreateTime(DateUtil.Date2String(new Date()));
        matter.setState(1);
        boolean isSuccess  = matterMapper.insert(matter)==1;
        if (isSuccess) {
            if (file != null && !file.isEmpty()) {
                if (file.getSize() > 10485760) {
                    jsonResult.markError("附件太大，请修改后重试！");
                    return jsonResult;
                } else {
                    FileUtil fu = new FileUtil();
                    String fileName = file.getOriginalFilename();
                    jsonResult = fu.saveFile(request, file, "attached");
                    MatterAttachment matterAttachment = new MatterAttachment();
                    matterAttachment.setUploadTime(DateUtil.Date2String(new Date()));
                    matterAttachment.setName(fileName);
                    matterAttachment.setUrl(jsonResult.getData().toString());
                    matterAttachment.setMatterId(matter.getId());
                    isSuccess = matterAttachmentMapper.insert(matterAttachment) == 1;
                    if (isSuccess) {
                        jsonResult.markSuccess("新增成功", null);
                    } else {
                        jsonResult.markError("新增失败");
                    }
                }
            } else {
                jsonResult.markSuccess("新增成功", null);
            }
        } else {
            jsonResult.markError("新增失败");
        }
        return jsonResult;
    }

    /**
     * 督查室登录后显示待任务分解的报告
     * @return
     */
    @Override
    public List<Matter> selectDecomposeMatters() {
//        List<Matter> matters = matterMapper.selectDecomposeMatters();
//        return (matters!=null && matters.size()>0)?matters:null;
        return  null;
    }

    /**
     * 督查室任务分解处理
     * @param matterId
     * @param matterTaskForm
     * @return
     */
    @Override
    public boolean doDecompose(Integer matterId, MatterTaskForm matterTaskForm) {
        Matter matter = matterMapper.selectByPrimaryKey(matterId);
        matter.setState(2);
        matterMapper.updateByPrimaryKey(matter);
        for(MatterTask matterTask:matterTaskForm.getMatterTasks()){
            if(matterTask.getCode()!=null && !"".equals(matterTask.getCode())){
                List<String> organizerNameList = toOrganizerNameList(matterTask.getOrganizerNames());
                matterTask.setMatterId(matterId);
                if(matterTaskMapper.insert(matterTask)!=1) {
                    return false;
                }

                //TODO orgName和orgId的获取和组织
                for(String orgId:organizerNameList){
                    MatterTaskResult taskResult = new MatterTaskResult();
                    taskResult.setTaskId(matterTask.getId());
                    taskResult.setMatterId(matterTask.getMatterId());
//                    taskResult.setOrganizerId());
                    taskResult.setOrganizerId(Integer.valueOf(orgId));
                    if(matterTaskResultMapper.insert(taskResult)!=1) {
                        return false;
                    }
                }

                HashMap map = Maps.newHashMap();
                //该任务的受理单位
                map.put("organizerIdList",organizerNameList);
                ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("zdgz", matterTask.getId().toString(),map);
                matterTask.setProcessInstanceId(Integer.valueOf(processInstance.getProcessInstanceId()));
                if(matterTaskMapper.updateByPrimaryKey(matterTask)!=1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 相关单位对任务签收
     * @param taskResultId
     * @return
     */
    @Override
    public boolean doSign(User user, Integer taskResultId) {
        MatterTaskResult matterTaskResult = matterTaskResultMapper.selectByPrimaryKey(taskResultId);

        matterTaskResult.setSignPersonId(user.getUserId());
        matterTaskResult.setSignPersonName(user.getUserName());
        matterTaskResult.setSignTime(DateUtil.Date2String(new Date()));
        if (matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)!=1){
            return false;
        }

        MatterTask matterTask = matterTaskMapper.selectByPrimaryKey(matterTaskResult.getTaskId());
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(matterTask.getProcessInstanceId().toString())
                .taskCandidateGroup(String.valueOf(user.getUnitId())).list();
        for(Task task:tasks){
            //TODO "任务签收"
            if("任务签收".equals(task.getName())){
                taskService.complete(task.getId());
                return true;
            }
        }
        return false;
    }

    /**
     * 相关单位对任务进行信息反馈
     */
    @Override
    public JsonResult doFeedback(User user, Integer matterTaskResultId, String content, MultipartFile file, HttpServletRequest request) {
//        JsonResult jsonResult = new JsonResult();
//        boolean isSuccess;
//        MatterTaskResult matterTaskResult = matterTaskResultMapper.getAllInfo(matterTaskResultId);
//
//        matterTaskResult.setFeedbackPersonId(user.getUnitId());
//        matterTaskResult.setFeedbackPersonName(user.getUserName());
//        matterTaskResult.setFeedbackTime(DateUtil.Date2String(new Date()));
//        isSuccess = matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)==1;
//        if (!isSuccess) {
//            jsonResult.markError("反馈失败，请联系管理员！");
//            return jsonResult;
//        }
//        if (file != null && !file.isEmpty()) {
//            if (file.getSize() > 10485760) {
//                jsonResult.markError("附件太大,请修改后重试！");
//                return jsonResult;
//            }
//            FileUtil fu = new FileUtil();
//            String fileName = file.getOriginalFilename();
//            //String fileType = fileName.substring(fileName.lastIndexOf("."));
//            jsonResult = fu.saveFile(request, file, "attached");
//            Feedback feedback = new Feedback();
//            feedback.setContent(content);
//            feedback.setName(fileName);
//            feedback.setUrl(jsonResult.getData().toString());
//            feedback.setTaskResultId((matterTaskResult.getId()));
//            isSuccess = feedbackMapper.insert(feedback)==1;
//        } else {
//            Feedback feedback = new Feedback();
//            feedback.setContent(content);
//            feedback.setTaskResultId((matterTaskResult.getId()));
//            isSuccess = feedbackMapper.insert(feedback)==1;
//        }
//        if (!isSuccess) {
//            jsonResult.markError("反馈失败，请联系管理员！");
//            return jsonResult;
//        }
//
//        Integer processInstanceId = matterTaskResult.getMatterTask().getProcessInstanceId();
//        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId.toString())
//                .taskCandidateGroup(String.valueOf(user.getUnitId())).list();
//        for(Task task:tasks){
//            //TODO "信息反馈"
//            if("信息反馈".equals(task.getName())){
//                taskService.complete(task.getId());
//            }
//        }
//
//        Integer matterId = matterTaskResult.getMatterId();
//        MatterTaskResultExample example = new MatterTaskResultExample();
//        example.or().andMatterIdEqualTo(matterId);
//        List<MatterTaskResult> matterTaskResults = matterTaskResultMapper.selectByExample(example);
//
//        List<Integer> resultIds = Lists.newArrayList();
//        for (MatterTaskResult taskResult:matterTaskResults){
//            Integer resultId = taskResult.getId();
//            resultIds.add(resultId);
//        }
//        FeedbackExample feedbackExample = new FeedbackExample();
//        feedbackExample.or().andTaskResultIdIn(resultIds);
//        List<Feedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
//        /*
//        判断是否所有的相关机构均完成了信息反馈
//         */
//        if (matterTaskResults.size()!=0 && matterTaskResults.size()==feedbacks.size()) {
//            Matter matter = matterMapper.selectByPrimaryKey(matterId);
//            matter.setState(3);
//            isSuccess = matterMapper.updateByPrimaryKey(matter)==1;
//            if(!isSuccess){
//                jsonResult.markError("反馈失败，请联系管理员！");
//                return jsonResult;
//            }
//        }
//        jsonResult.markSuccess("反馈成功！",null);
//        return jsonResult;
        return null;
    }


    /**
     * 获取所有机构已做信息反馈的报告
     * @return
     */
    @Override
    public List<Matter> getAllSummaryMatter() {
        MatterExample example = new MatterExample();
        example.or().andStateEqualTo(3);
        List<Matter> matters = matterMapper.selectByExample(example);
        return (matters!=null && matters.size()>0)?matters: Collections.<Matter>emptyList();
    }

    /**
     * 督查室对各个机构的信息反馈进行汇总形成年度目标
     * @return
     */
    @Override
    public JsonResult doSummary(User user, Integer matterId, String summary, MultipartFile file, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        boolean isSuccess;
        Matter matter = matterMapper.selectByPrimaryKey(matterId);
        matter.setState(4);
        isSuccess = matterMapper.updateByPrimaryKey(matter)==1;
        if (!isSuccess) {
            jsonResult.markError("汇总失败，请联系管理员！");
            return jsonResult;
        }
        if (file != null && !file.isEmpty()) {
            if (file.getSize() > 10485760) {
                jsonResult.markError("附件太大,请修改后重试！");
                return jsonResult;
            }
            FileUtil fu = new FileUtil();
            String fileName = file.getOriginalFilename();
            //String fileType = fileName.substring(fileName.lastIndexOf("."));
            jsonResult = fu.saveFile(request, file, "attached");
            Summary summary1 = new Summary();
            summary1.setMatterId(matterId);
            summary1.setName(fileName);
            summary1.setUrl(jsonResult.getData().toString());
            summary1.setContent(summary);
            isSuccess = summaryMapper.insert(summary1)==1;
        } else {
            Summary summary1 = new Summary();
            summary1.setMatterId(matterId);
            summary1.setContent(summary);
            isSuccess = summaryMapper.insert(summary1)==1;
        }
        if(!isSuccess){
            jsonResult.markError("汇总失败，请联系管理员！");
            return jsonResult;
        }

        /*
        督查室进行报告汇总的时候，所有分解任务的流程的"报告汇总"task都complete
         */
        MatterTaskExample example = new MatterTaskExample();
        example.or().andMatterIdEqualTo(matterId);
        List<MatterTask> matterTasks = matterTaskMapper.selectByExample(example);
        for (MatterTask matterTask:matterTasks) {
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(matterTask.getProcessInstanceId().toString()).taskCandidateGroup(String.valueOf(user.getUnitId())).list();
            for (Task task:tasks) {
                //TODO "报告汇总"
                if ("报告汇总".equals(task.getName())) {
                    taskService.complete(task.getId());
                }
            }
        }
        jsonResult.markSuccess("汇总成功",null);
        return jsonResult;
    }

    /**
     * 督查室对相关机构上报结果进行判断
     * @param type 1：通过 0：未通过
     * @param matterTaskResultId
     * @param unPassReason
     * @return
     */
    @Override
    public boolean doJudge(User user, String type, Integer matterTaskResultId, String unPassReason) {
//        MatterTaskResult matterTaskResult = matterTaskResultMapper.getAllInfo(matterTaskResultId);
//        Integer processInstanceId = matterTaskResult.getMatterTask().getProcessInstanceId();
//        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId.toString())
//                .taskCandidateGroup(String.valueOf(user.getUnitId())).list();
//        HashMap map = Maps.newHashMap();
//        if("1".equals(type)){
//            matterTaskResult.setRemark("1");
//            boolean isSuccess = matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)==1;
//            if (isSuccess) {
//                map.put("supervisionPass", true);
//                for (Task task : tasks) {
//                    if ("结果判断".equals(task.getName()) && task.getExecutionId().equals(matterTaskResult.getExecutionId().toString())) {
//                        synchronized (this) {
//                            taskService.complete(task.getId(), map);
//                            return true;
//                        }
//                    }
//                }
//            }
//        } else if("0".equals(type)) {
//            matterTaskResult.setRemark(unPassReason);
//            boolean isSuccess = matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)==1;
//            if(isSuccess){
//                map.put("supervisionPass",false);
//                for (Task task:tasks) {
//                    if ("结果判断".equals(task.getName()) && task.getExecutionId().equals(matterTaskResult.getExecutionId().toString())) {
//                        synchronized (this){
//                            taskService.complete(task.getId(),map);
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
        return false;
    }

    /**
     * 根据报告id查询分解后的任务列表
     * @param matterId
     * @return
     */
    @Override
    public List<MatterTask> getTaskListByMatterId(Integer matterId) {
        MatterTaskExample example = new MatterTaskExample();
        example.or().andMatterIdEqualTo(matterId);
        List<MatterTask> matterTasks = matterTaskMapper.selectByExample(example);
        return matterTasks.size()>0?matterTasks:Collections.<MatterTask>emptyList();
    }

    /**
     * 相关机构对受理任务进行结果上报
     * @param taskResultId
     * @param reportContent
     * @param file
     * @param request
     * @return
     */
    @Override
    public JsonResult doReport(User user, Integer taskResultId, String reportContent, MultipartFile file, HttpServletRequest request) {
//        JsonResult jsonResult = new JsonResult();
//        MatterTaskResult matterTaskResult = matterTaskResultMapper.getAllInfo(taskResultId);
//
//        matterTaskResult.setReportPersonId(user.getUserId());
//        matterTaskResult.setReportPersonName(user.getUserName());
//        matterTaskResult.setReportTime(DateUtil.Date2String(new Date()));
//        boolean isSuccess = matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)==1;
//        if (!isSuccess) {
//            jsonResult.markError("上报失败，请联系管理员！");
//            return jsonResult;
//        }
//
//        if (file != null && !file.isEmpty()) {
//            if (file.getSize() > 10485760) {
//                jsonResult.markError("附件太大,请修改后重试！");
//                return jsonResult;
//            }
//            FileUtil fu = new FileUtil();
//            String fileName = file.getOriginalFilename();
//            //String fileType = fileName.substring(fileName.lastIndexOf("."));
//            jsonResult = fu.saveFile(request, file, "attached");
//            Report report = new Report();
//            report.setContent(reportContent);
//            report.setName(fileName);
//            report.setUrl(jsonResult.getData().toString());
//            report.setTaskResultId((matterTaskResult.getId()));
//            isSuccess = reportMapper.insert(report)==1;
//        } else {
//            Report report = new Report();
//            report.setContent(reportContent);
//            report.setTaskResultId((matterTaskResult.getMatterId()));
//            isSuccess = reportMapper.insert(report)==1;
//        }
//        if (!isSuccess) {
//            jsonResult.markError("上报失败，请联系管理员！");
//            return jsonResult;
//        }
//
//        Integer processInstanceId = matterTaskResult.getMatterTask().getProcessInstanceId();
//        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId.toString())
//                .taskCandidateGroup(String.valueOf(user.getUnitId())).list();
//        for(Task task:tasks){
//            //TODO "结果上报"
//            if("结果上报".equals(task.getName())){
//                matterTaskResult.setExecutionId(Integer.valueOf(task.getExecutionId()));
//                isSuccess = matterTaskResultMapper.updateByPrimaryKey(matterTaskResult)==1;
//                if (!isSuccess) {
//                    jsonResult.markError("上报失败，请联系管理员！");
//                    return jsonResult;
//                }
//                taskService.complete(task.getId());
//            }
//        }
//        jsonResult.markSuccess("上报成功",null);
//        return jsonResult;
        return null;
    }

    /**
     * 查询办事信息，如果id为null，则返回所有
     * @param id
     * @return
     */
    public List<Matter> getMaterAllInfo(Integer id){
//        List<Matter> matters = matterMapper.getMaterAllInfo(id);
//        for(Matter matter:matters){
//            MatterAttachmentExample matterAttachmentExample = new MatterAttachmentExample();
//            matterAttachmentExample.or().andMatterIdEqualTo(matter.getId());
//            matterAttachmentExample.setOrderByClause("id desc");
//            List<MatterAttachment> matterAttachments = matterAttachmentMapper.selectByExample(matterAttachmentExample);
//            matter.setMatterAttachments(matterAttachments);
//        }
//        return matters;
        return null;
    }

    /**
     * 将该任务的受理机构name字符串转换为list
     * @param organizerNames
     * @return
     */
    private List<String> toOrganizerNameList(String organizerNames) {
        //TODO orgName数据组织
        List<String> organizerNameList = Lists.newArrayList();
        String[] names = organizerNames.split("、");
        for(String name:names){
//            if(group!=null){
                organizerNameList.add(name);
//            }
        }
        return organizerNameList.size()>0?organizerNameList:Collections.<String>emptyList();
    }

    @Override
    public List<Matter> selectAll() {
        List<Matter> matters = matterMapper.selectByExample(new MatterExample());
        return matters.size()>0?matters:Collections.<Matter>emptyList();
    }

    @Override
    public Matter selectById(Integer matterId) {
        return matterMapper.selectByPrimaryKey(matterId);
    }

    @Override
    public boolean deleteByIds(List<Integer> idList) {
        return false;
    }

    @Override
    public boolean updateByExample(Matter matter, MatterExample matterExample) {
        return false;
    }

    @Override
    public JsonResult updateByPrimaryKey(User user, Matter matter, MultipartFile file, HttpServletRequest request, JsonResult jsonResult) {

        //处理新增matter和event
        matter.setState(1);
        boolean isSuccess  = matterMapper.updateByPrimaryKeySelective(matter)==1;
        if (isSuccess) {
            if (file != null && !file.isEmpty()) {
                if (file.getSize() > 10485760) {
                    jsonResult.markError("附件太大，请修改后重试！");
                    return jsonResult;
                } else {
                    FileUtil fu = new FileUtil();
                    String fileName = file.getOriginalFilename();
                    //String fileType = fileName.substring(fileName.lastIndexOf("."));
                    jsonResult = fu.saveFile(request, file, "attached");
                    MatterAttachment matterAttachment = new MatterAttachment();
                    matterAttachment.setUploadTime(DateUtil.Date2String(new Date()));
                    matterAttachment.setName(fileName);
                    matterAttachment.setUrl(jsonResult.getData().toString());
                    matterAttachment.setMatterId(matter.getId());
                    isSuccess = matterAttachmentMapper.insert(matterAttachment)==1;
                    if (isSuccess) {
                        jsonResult.markSuccess("编辑成功", null);
                    } else {
                        jsonResult.markError("编辑失败");
                    }
                }
            } else {
                jsonResult.markSuccess("编辑成功", null);
            }
        } else {
            jsonResult.markError("编辑失败");
        }
        return jsonResult;
    }

}
