package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.ProcessMeasureCheck;
import com.ssm.service.qualityControl.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_measure_check")
public class ProcessMeasureCheckController{

    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("find")
    public String find(){
        return "p_measure_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<ProcessMeasureCheck> list(Integer page,Integer rows){
        int offset = (page -1) * rows;
        int allCount = processMeasureCheckService.findAllCount();
        List<ProcessMeasureCheck> list = processMeasureCheckService.findByPage(rows, offset);
        ResponseVO<ProcessMeasureCheck> vo = new ResponseVO<ProcessMeasureCheck>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }
    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String pMeasureCheckId, String note) {
        int i = processMeasureCheckService.updateNote(pMeasureCheckId, note);
        return ResponseMessage.getMessage(i);

    }
}