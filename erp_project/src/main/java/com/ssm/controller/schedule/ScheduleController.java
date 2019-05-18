package com.ssm.controller.schedule;

import com.ssm.bean.schedule.Custom;
import com.ssm.bean.schedule.CustomVO;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.service.schedule.ScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("custom/find")
    public String customList(Model model){
        return "custom_list";
    }

    @RequestMapping("custom/list")
    @ResponseBody
    public CustomVO custom(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        //List<Custom> customs = scheduleService.queryPageCustom();
        List<Custom> customs = scheduleService.queryPageCustom(pageDetail);

        CustomVO customVO = new CustomVO();

        customVO.setRows(customs);
        customVO.setTotal(scheduleService.queryAllRecord());
        return customVO;


    }

    @RequestMapping("custom/add_judge")
    @ResponseBody
    public Custom addJudge(){
        Custom object = new Custom();
        return object;
    }

    @RequestMapping("custom/add")
    public String customAdd(){
        return "custom_add";
    }

    @RequestMapping("custom/insert")
    @ResponseBody
    public Map customInsert(Custom custom){
        HashMap<String, Object> insertCustomResult = new HashMap<>();
        int i = scheduleService.insertCustom(custom);
        if (i > 0) {
            insertCustomResult.put("status", 200);
            insertCustomResult.put("msg", "OK");
            insertCustomResult.put("data", null);
        } else {
            insertCustomResult.put("status", 404);
            insertCustomResult.put("msg", "fail");
            insertCustomResult.put("data", "insert fail");
        }
        return insertCustomResult;
    }
}
