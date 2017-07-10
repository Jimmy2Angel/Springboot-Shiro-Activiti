package indi.baojie.demo.supervision.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import indi.baojie.demo.common.data.JsonResult;
import indi.baojie.demo.supervision.domain.Matter;
import indi.baojie.demo.supervision.domain.Role;
import indi.baojie.demo.supervision.domain.Unit;
import indi.baojie.demo.supervision.domain.User;
import indi.baojie.demo.supervision.service.MatterService;
import indi.baojie.demo.supervision.service.UnitService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Lollipop on 2017/6/23.
 */
@RestController
public class MatterController extends BaseController{

    @Autowired
    private UnitService unitService;
    @Autowired
    private MatterService matterService;

    @GetMapping("/index")
    public ModelAndView index(){

        //TODO 获取首页数据
        User user = currentUser();
        List<Integer> roleIds = Lists.newArrayList();
        Set<Role> roles = user.getRoles();
        for(Role role:roles){
            roleIds.add(role.getRoleId());
        }
        ModelAndView modelAndView = null;

        List<Matter> leaderMatter = this.getMatter("1");  //领导审批
        List<Matter> officeMatter = this.getMatter("3");  //办公厅交办

        if (roleIds.contains(2)) {   //督查室

            List<Matter> supervisionMatter = this.getMatter("2");  //督查提交&督查判断,之后去掉督查判断
            List<Matter> supMatter = Lists.newArrayList();  //进入子流程办理中的办件，也包括督查判断
            List<Matter> supervisionJudgeMatter = Lists.newArrayList(); //督查判断
            modelAndView = new ModelAndView("supervision/index");

            List<Execution> executionList = runtimeService.createExecutionQuery().list();
            Set<String> processInstanceIdSet = Sets.newHashSet();
            for (Execution execution : executionList) {
                if (!execution.getId().equals(execution.getProcessInstanceId())) {  //不等 说明进入子流程了
                    processInstanceIdSet.add(execution.getProcessInstanceId());
                }
            }

            if (!processInstanceIdSet.isEmpty()) {
                List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().processInstanceIds(processInstanceIdSet).list();  //进入子流程的督查任务

                if (!processInstanceList.isEmpty()) {
                    for (ProcessInstance processInstance : processInstanceList) {
                        Integer matterId = Integer.valueOf(processInstance.getBusinessKey());
                        Matter matter = matterService.getMaterAllInfo(matterId).get(0);
                        matter.setProcessInstance(processInstance);
                        supMatter.add(matter);
                    }
                }
            }

            //supervisionMatter去除处于子流程中督查判断的办件,并将其添加到supervisionJudgeMatter中
            List<Integer> supervisionJudgeMatterIds = Lists.newArrayList();
            Iterator<Matter> iterator = supervisionMatter.iterator();
            while (iterator.hasNext()) {
                Matter matter = iterator.next();
                for (Matter matter1 : supMatter) {
                    if (matter.getId() == matter1.getId()) {
                        if (!supervisionJudgeMatterIds.contains(matter.getId())) {
                            supervisionJudgeMatterIds.add(matter.getId());
                            supervisionJudgeMatter.add(matter);
                        }
                        iterator.remove();
                    }
                }
            }
            modelAndView.addObject("supervisionMatter", supervisionMatter);             //处于督查提交的办件
            modelAndView.addObject("supervisionJudgeMatter", supervisionJudgeMatter);   //处于机构办理中督查判断的办件
            modelAndView.addObject("leaderMatter", leaderMatter);                       //处于领导批示的办件
            modelAndView.addObject("officeMatter", officeMatter);                       //处于办公厅交办的办件
            modelAndView.addObject("supMatter", supMatter);                             //处于机构办理中的办件
            modelAndView.addObject("finishMatter", getHisMatter());                      //流程已经走完的办件
            return modelAndView;
        } else if (roleIds.contains(1)) {  //领导
            modelAndView = new ModelAndView("supervision/leader_index");
            modelAndView.addObject("leaderMatter", leaderMatter); //待办
            List<Matter> leaderRunMatter = getLeaderHanded("1").get(0);

            /**
             * 如果已办列表不需要显示审批未通过的办件，则把这段注释
             */
            Iterator<Matter> iterator = leaderRunMatter.iterator();
            while (iterator.hasNext()) {
                Matter matter = iterator.next();
                for (Matter matter1 : leaderMatter) {
                    if (matter.getId() == matter1.getId()) {
                        iterator.remove();
                    }
                }
            }

            modelAndView.addObject("leaderRunMatter", leaderRunMatter); //已办：未办结
            modelAndView.addObject("leaderEndMatter", getLeaderHanded("1").get(1)); //已办：已办结
            return modelAndView;
        } else if (roleIds.contains(3)) {  //办公厅
            modelAndView = new ModelAndView("supervision/leader_index");
            modelAndView.addObject("officeMatter", officeMatter); //待办
            modelAndView.addObject("officeRunMatter", getLeaderHanded("3").get(0)); //已办：未办结
            modelAndView.addObject("officeEndMatter", getLeaderHanded("3").get(1)); //已办：已办结
            return modelAndView;
        } else {                                              //受理部门
            modelAndView = new ModelAndView("supervision/department_matter_list");
            List<Matter> departMatter = this.getMatter(String.valueOf(roleIds.get(0)));
            List<Matter> hisMatterList = getDepartmentMatter(String.valueOf(roleIds.get(0)));
            modelAndView.addObject("departMatter", departMatter);
            modelAndView.addObject("hisMatterList", hisMatterList);
            return modelAndView;
        }
    }

    /**
     * 新增办件页面显示
     */
    @GetMapping("/matter/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("supervision/matter_add");
        List<Unit> units = unitService.selectAll();
        modelAndView.addObject("url", "add");
        modelAndView.addObject("units",units);
        return modelAndView;
    }

    /**
     * 新增办件处理
     */
    @PostMapping("/matter/add")
    public JsonResult add(HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }


    public List<Matter> getMatter(String group) {
        User user = currentUser();
        List<Matter> matterList = Lists.newArrayList();
        List<Task> taskList = taskService.createTaskQuery().taskCandidateGroup(group).list();  // supervise 表示督查室的组名称
        //List<Task> taskList3 =taskService.createTaskQuery().taskAssignee(user.getId().toString()).list();   //查询已经签收的任务， 已签收的任务只对自己可见。
        //taskList.addAll(hisTaskList);
        for (Task task : taskList) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            if (processInstance == null) {
                continue;
            }

            String matterId = processInstance.getBusinessKey();  //关联业务id
            if (Strings.isNullOrEmpty(matterId)) {
                continue;
            }
            List<Matter> matters = matterService.getMaterAllInfo(Integer.valueOf(matterId));
            Matter matter = matters.get(0);


            matter.setProcessInstance(processInstance);
            matter.setTask(task);
            matterList.add(matter);
        }
        return matterList;
    }

    /**
     * 已办结办件
     *
     * @return
     */
    public List<Matter> getHisMatter() {
        List<Matter> matterList = Lists.newArrayList();
        List<HistoricProcessInstance> historicProcessInstanceList = historyService.createHistoricProcessInstanceQuery().finished().list();//历史流程实例
        for (HistoricProcessInstance historicProcessInstance : historicProcessInstanceList) {
            if (historicProcessInstance == null) {
                continue;
            }
            String matterId = historicProcessInstance.getBusinessKey();  //关联业务id
            if (Strings.isNullOrEmpty(matterId)) {
                continue;
            }
            List<Matter> matters = matterService.getMaterAllInfo(Integer.valueOf(matterId));
            if (matters != null && !matters.isEmpty()) {
                Matter matter = matters.get(0);
                matter.setHistoricProcessInstance(historicProcessInstance);
//                matter.setLocalState("已办结");
                matterList.add(matter);
            }
        }
        return matterList;
    }

    /**
     * 查询领导和办公厅已办办件
     * 分为已办结、未办结
     * 310000000：领导
     * 320000000：办公厅
     *
     * @return
     */
    public List<List<Matter>> getLeaderHanded(String orgCode) {
        List<List<Matter>> matters = Lists.newArrayList();
        List<Matter> runMatters = Lists.newArrayList();
        List<Matter> endMatters = Lists.newArrayList();
        List<Integer> matterIdflag = Lists.newArrayList();

        List<HistoricTaskInstance> historicTaskInstances = historyService.createHistoricTaskInstanceQuery().taskCandidateGroup(orgCode).finished().list();
        for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
            if (historicTaskInstance == null) {
                continue;
            }
            String processInstanceId = historicTaskInstance.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            //流程已走完
            if (processInstance == null) {
                HistoricProcessInstance historicProcessInstance =
                        historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).finished().singleResult();
                if (historicProcessInstance == null) {
                    continue;
                }
                String matterId = historicProcessInstance.getBusinessKey();
                if (Strings.isNullOrEmpty(matterId)) {
                    continue;
                }
                Matter matter = matterService.getMaterAllInfo(Integer.valueOf(matterId)).get(0);
                matter.setHistoricProcessInstance(historicProcessInstance);
//                matter.setLocalState("已办结");
                endMatters.add(matter);
            } else {
                if (processInstance == null) {
                    continue;
                }
                String matterId = processInstance.getBusinessKey();
                if (Strings.isNullOrEmpty(matterId)) {
                    continue;
                }
                //去重（否则第一次领导批示未通过的办件会显示多次）
                if (!matterIdflag.contains(Integer.valueOf(matterId))) {
                    matterIdflag.add(Integer.valueOf(matterId));
                    Matter matter = matterService.getMaterAllInfo(Integer.valueOf(matterId)).get(0);
                    matter.setProcessInstance(processInstance);
                    runMatters.add(matter);
                }
            }
        }
        matters.add(runMatters);
        matters.add(endMatters);
        return matters;
    }

    /**
     * 查询受理部门的已办办件---即不包括自己的待办件
     *
     * @param orgs
     * @return
     */
    public List<Matter> getDepartmentMatter(String orgs) {
        List<Matter> matterList = Lists.newArrayList();
//        List<Task> taskList = taskService.createTaskQuery().taskCandidateGroup(orgs).list();
//        List<String> processInstanceList = Lists.newArrayList();
//        if (taskList != null && !taskList.isEmpty()) {
//            for (Task task : taskList) {
//                processInstanceList.add(task.getProcessInstanceId());
//            }
//        }
//        List<TransactionResult> transactionResultList = transactionResultService.selectInfo(orgs);  //所有跟自己关联的办件
//        for (TransactionResult transactionResult : transactionResultList) {
//            Matter matter = transactionResult.getMatter();
//            matter = matterService.getMaterAllInfo(matter.getId()).get(0);
//            String processInstanscessId = transactionResult.getMatter().getProcessInstanceId();
//            // runtimeService.createProcessInstanceQuery().processInstanceId(processInstanscessId).singleResult();
//            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanscessId).finished().singleResult();  //查询已经办结的历史任务
//            //historicProcessInstance.
//            if (historicProcessInstance == null) { //说明还在办理中
//                if (!processInstanceList.contains(processInstanscessId)) {  //从正在办理的中筛选
//                    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanscessId).singleResult();  //正在运行的实例但不是自己的办件
//                    matter.setProcessInstance(processInstance);
//                    matterList.add(matter);
//                }
//            } else {  //已经结束
//                matter.setHistoricProcessInstance(historicProcessInstance);
//                matterList.add(matter);
//            }
//
//        }
        return matterList;
    }
}
