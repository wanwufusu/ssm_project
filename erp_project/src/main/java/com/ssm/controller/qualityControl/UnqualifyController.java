package com.ssm.controller.qualityControl;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.UnqualifyApply;
import com.ssm.service.qualityControl.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("unqualify")
public class UnqualifyController {

    @Autowired
    UnqualifyService unqualifyService;

    @RequestMapping("find")
    public String find(){
        return "unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<UnqualifyApply> list(Integer page,Integer rows){
        int offset = (page -1) * rows;
        int allCount = unqualifyService.findAllCount();
        List<UnqualifyApply> list = unqualifyService.findByPage(rows, offset);
        ResponseVO<UnqualifyApply> vo = new ResponseVO<UnqualifyApply>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String unqualifyApplyId,String note){
        int i = unqualifyService.updateNote(unqualifyApplyId, note);
        return ResponseMessage.getMessage(i);
    }
}
