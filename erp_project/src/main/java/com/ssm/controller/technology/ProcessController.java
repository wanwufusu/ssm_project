package com.ssm.controller.technology;

import com.ssm.bean.technology.Process;
import com.ssm.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> getData(){
        List<Process> data = processService.findAll();
        return data;
    }
}
