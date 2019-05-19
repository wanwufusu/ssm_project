package com.ssm.controller.qualityControl;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.UnqualifyApply;
import com.ssm.service.qualityControl.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("unqualify")
public class UnqualifyController {

    @Autowired
    UnqualifyService service;

    @RequestMapping("find")
    public String find(){
        return "unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<UnqualifyApply> list(Integer page,Integer rows){
        int offset = (page -1) * rows;
        int allCount = service.findAllCount();
        List<UnqualifyApply> list = service.findByPage(rows, offset);
        ResponseVO<UnqualifyApply> vo = new ResponseVO<UnqualifyApply>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String unqualifyApplyId,String note){
        int i = service.updateNote(unqualifyApplyId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        int i = service.deleteByIds(ids);
        return ResponseMessage.getMessage(i);
    }

    //unqualifyId
    //productName
    @RequestMapping("search_unqualify_by_{which}")
    @ResponseBody
    public ResponseVO searchList(@PathVariable("which")String which,String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;



        ResponseVO<Object> vo = new ResponseVO<>();

        return vo;
    }
}
