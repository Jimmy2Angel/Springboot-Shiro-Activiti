package indi.baojie.supervision.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import indi.baojie.common.data.JsonResult;
import indi.baojie.common.data.TreeNode;
import indi.baojie.supervision.domain.Group;
import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lollipop on 2017/6/23.
 */
@Controller
@RequestMapping("matter")
public class MatterController extends BaseController{

    @Autowired
    private UnitService unitService;
    @Autowired
    private MatterService matterService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private MatterTaskResultService matterTaskResultService;
    @Autowired
    private MatterAttachmentService matterAttachmentService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request){

//        User user = currentUser();
//        /**
//         * 督查室登录首页显示
//         * 任务分解、信息反馈汇总、年度目标交办、相关单位上报结果判断
//         */
//        if(user.getUnitId().equals(Constants.SUPERVISOR_CODE)){
//            ModelAndView modelAndView = new ModelAndView("index");
//            List<Matter> taskDecomposeMatters = matterService.selectDecomposeMatters();  //待任务分解的报告
//            List<Matter> summaryMatters = matterService.getAllSummaryMatter();  //待汇总的报告
//            List<Summary> summaries = summaryService.selectSummaryWithMatter();  //汇总后的报告年度目标
//            List<MatterTaskResult> reportedTaskResults = matterTaskResultService.selectTaskResults(user,"结果判断");   //待判断的上报结果集合
//            List<Matter> allMatters = matterService.selectAll();
//            modelAndView.addObject("taskDecomposeMatters",taskDecomposeMatters);
//            modelAndView.addObject("summaryMatters",summaryMatters);
//            modelAndView.addObject("summaries",summaries);
//            modelAndView.addObject("reportedTaskResults",reportedTaskResults);
//            modelAndView.addObject("allMatters",allMatters);
//            return modelAndView;
//        }
//        /**
//         * 相关单位登录首页显示
//         * 待签收、待信息反馈、待上报
//         */
//        else {
//            ModelAndView modelAndView = new ModelAndView("index2");
//            List<MatterTaskResult> signTaskResults = matterTaskResultService.selectTaskResults(user,"任务签收");  //待信息反馈的任务
//            List<MatterTaskResult> feedbackTaskResults = matterTaskResultService.selectTaskResults(user,"信息反馈");  //待信息反馈的任务
//            List<MatterTaskResult> reportTaskResults = matterTaskResultService.selectTaskResults(user,"结果上报");    //待上报的任务
//            List<MatterTaskResult> allTaskResults = matterTaskResultService.selectAllByOrganizerId(String.valueOf(user.getUnitId()));    //当前用户所属机构相关的全部任务
//            modelAndView.addObject("signTaskResults",signTaskResults);
//            modelAndView.addObject("feedbackTaskResults",feedbackTaskResults);
//            modelAndView.addObject("reportTaskResults",reportTaskResults);
//            modelAndView.addObject("allTaskResults",allTaskResults);
//            return modelAndView;
//        }

        return new ModelAndView("supervision/index");
    }

    /**
     * 新增办件页面显示
     */
    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("url", "submit_add");
        return "supervision/matter_add";
    }

    /**
     * 新增办件处理
     * @param matter
     * @param file
     * @param request
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult add(Matter matter, MultipartFile file,HttpServletRequest request) {
        User user = new User();
        JsonResult jsonResult = new JsonResult();
        jsonResult = matterService.addMatter(user, matter, file, request, jsonResult);
        return jsonResult;
    }

    /**
     * 获取机构树
     *
     * @return
     */
    @RequestMapping("tree")
    @ResponseBody
    public String getTree(Integer matterId) {

        List<Map<String, Object>> treeNodes = Lists.newArrayList();

        TreeNode treeNode = null;
        Map map = null;
        List<String> unitIdList = new ArrayList<>();
        List<String> unitNameList = new ArrayList<>();
        List<Group> groupList = groupService.selectAllGroup();
        Matter matter = matterService.selectById(matterId);
        if (matter != null) {
            String unitIds = matter.getUnitIds();
            String unitNames = matter.getUnitNames();

            if (!Strings.isNullOrEmpty(unitIds) && !Strings.isNullOrEmpty(unitNames)) {
                for (int i = 0; i < unitIds.split(",").length; i++) {
                    if (unitIds.split(",")[i] != null && unitIds.split(",")[i] != "")
                        unitIdList.add(unitIds.split(",")[i]);
                }
                unitNames = unitNames.replace("【", "");
                //orgNames = orgNames.replace("】","");
                for (int i = 0; i < unitNames.split("】").length; i++) {
                    if (unitNames.split("】")[i] != null && unitNames.split("】")[i] != "")
                        unitNameList.add(unitNames.split("】")[i].trim());
                }

            }
        }
        for (Group group : groupList) {
            treeNode = new TreeNode.TreeNodeBuilder().id(group.getOrgCode()).name(group.getOrgName()).pId(group.getParentCode()).open(false).builder();

            if ((!unitIdList.isEmpty()) && unitIdList.contains(treeNode.getId()) && unitNameList.contains(treeNode.getName())) {
                treeNode.setChecked(true);
            }
            map = Maps.newHashMap();
            map.put("id", treeNode.getId());
            map.put("name", treeNode.getName());
            map.put("open", treeNode.getOpen());
            map.put("checked", treeNode.getChecked());
            map.put("pId", treeNode.getpId());
            treeNodes.add(map);
        }
        return JSON.toJSONString(treeNodes);
    }
}
