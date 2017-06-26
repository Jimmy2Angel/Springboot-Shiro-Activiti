package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.common.data.JsonResult;
import indi.baojie.demo.supervision.domain.Unit;
import indi.baojie.demo.supervision.service.UnitService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Lollipop on 2017/6/23.
 */
@RestController
public class MatterController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/index")
    public ModelAndView index(){
        //TODO 获取首页数据
        return new ModelAndView("main/index");
    }

    /**
     * 新增办件页面显示
     */
    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("supervision/add");
        List<Unit> units = unitService.selectAll();
        modelAndView.addObject("url", "add");
        modelAndView.addObject("units",units);
        return modelAndView;
    }

    /**
     * 新增办件处理
     */
    @PostMapping("/add")
    public JsonResult add(HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }
}
