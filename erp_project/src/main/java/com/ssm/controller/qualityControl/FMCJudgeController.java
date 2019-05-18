package com.ssm.controller.qualityControl;


import com.ssm.bean.qualityControl.ProcessMeasureCheck;
import com.ssm.service.qualityControl.impl.FinalMeasureCheckServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("fMeasureCheck")
public class FMCJudgeController {

    @RequestMapping("edit_judge")
    @ResponseBody
    public ProcessMeasureCheck edit_judge(){
        return new ProcessMeasureCheck();
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public ProcessMeasureCheck add_judge(){
        return new ProcessMeasureCheck();
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public ProcessMeasureCheck delete_judge(){
        return new ProcessMeasureCheck();
    }

}
