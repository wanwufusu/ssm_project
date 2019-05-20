package com.ssm.controller;


import com.ssm.bean.qualityControl.ProcessMeasureCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JudgeController {

    @RequestMapping("{kind}/{op}_judge")
    @ResponseBody
    public String edit_judge(@PathVariable("kind") String kind,@PathVariable("op")String op){
        if ("add".equals(op)){
            return "add";
        }else if ("delete".equals(op)){
            return "delete";
        }else if ("edit".equals(op)){
            return "edit";
        }else {
            return "nothing";
        }
    }
}
