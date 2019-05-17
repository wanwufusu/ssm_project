package com.ssm.controller;

import com.ssm.bean.Custom;
import com.ssm.bean.CustomVO;
import com.ssm.bean.User;
import com.ssm.service.schedule.ScheduleService;
import com.ssm.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("/custom")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("find")
    public String customList(Model model){
        return "custom_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public CustomVO custom(Model model){

        List<Custom> customs = scheduleService.queryPageCustom();

        CustomVO customVO = new CustomVO();

        customVO.setRows(customs);
        customVO.setTotal(customs.size());
        return customVO;
    }

}
