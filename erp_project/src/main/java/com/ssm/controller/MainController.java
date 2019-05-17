package com.ssm.controller;

import com.ssm.bean.User;
import com.ssm.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Controller()
@RequestMapping("/erp")
public class MainController {

    @Autowired
    TestService testService;

    @RequestMapping("home")
    public String MainTest(Model model){
        return "home";
    }
}
