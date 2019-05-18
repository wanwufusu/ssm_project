package com.ssm.controller.qualityControl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fCountCheck")
public class FCCJudgeController {

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return " ";
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return " ";
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return " ";
    }
}
