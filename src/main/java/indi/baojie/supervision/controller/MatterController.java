package indi.baojie.supervision.controller;

import indi.baojie.common.data.Constants;
import indi.baojie.supervision.domain.Matter;
import indi.baojie.supervision.domain.MatterTaskResult;
import indi.baojie.supervision.domain.Summary;
import indi.baojie.supervision.service.MatterService;
import indi.baojie.supervision.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Lollipop on 2017/6/23.
 */
@RestController
public class MatterController extends BaseController{

    @Autowired
    private UnitService unitService;
    @Autowired
    private MatterService matterService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request){

        /**
         * 督查室登录首页显示
         * 任务分解、信息反馈汇总、年度目标交办、相关单位上报结果判断
         */
        if(currentUser().getUnitId().equals(Constants.SUPERVISOR_CODE)){
            ModelAndView modelAndView = new ModelAndView("index");
            List<Matter> taskDecomposeMatters = matterService.selectDecomposeMatters();  //待任务分解的报告
            List<Matter> summaryMatters = matterService.getAllSummaryMatter();  //待汇总的报告
            List<Summary> summaries = summaryService.selectSummaryWithMatter();  //汇总后的报告年度目标
            List<MatterTaskResult> reportedTaskResults = matterTaskResultService.selectTaskResults(person,"结果判断");   //待判断的上报结果集合
            List<Matter> allMatters = matterService.selectAll();
            modelAndView.addObject("taskDecomposeMatters",taskDecomposeMatters);
            modelAndView.addObject("summaryMatters",summaryMatters);
            modelAndView.addObject("summaries",summaries);
            modelAndView.addObject("reportedTaskResults",reportedTaskResults);
            modelAndView.addObject("allMatters",allMatters);
            return modelAndView;
        }
        /**
         * 相关单位登录首页显示
         * 待签收、待信息反馈、待上报
         */
        else {
            ModelAndView modelAndView = new ModelAndView("index2");
            List<MatterTaskResult> signTaskResults = matterTaskResultService.selectTaskResults(person,"任务签收");  //待信息反馈的任务
            List<MatterTaskResult> feedbackTaskResults = matterTaskResultService.selectTaskResults(person,"信息反馈");  //待信息反馈的任务
            List<MatterTaskResult> reportTaskResults = matterTaskResultService.selectTaskResults(person,"结果上报");    //待上报的任务
            List<MatterTaskResult> allTaskResults = matterTaskResultService.selectAllByOrganizerId(person.getOrgCode());    //当前用户所属机构相关的全部任务
            modelAndView.addObject("signTaskResults",signTaskResults);
            modelAndView.addObject("feedbackTaskResults",feedbackTaskResults);
            modelAndView.addObject("reportTaskResults",reportTaskResults);
            modelAndView.addObject("allTaskResults",allTaskResults);
            return modelAndView;
        }
    }
}
