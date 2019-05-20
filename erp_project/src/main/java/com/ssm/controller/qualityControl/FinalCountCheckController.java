package com.ssm.controller.qualityControl;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.FinalCountCheck;
import com.ssm.service.qualityControl.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/f_count_check")
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;
    /**
     * 成品计数质检的list及刷新
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<FinalCountCheck> list(Integer page,Integer rows){
        int offset= (page - 1) * rows;
        List<FinalCountCheck> byPage = finalCountCheckService.findByPage(rows, offset);
        int allCount = finalCountCheckService.findAllCount();
        ResponseVO<FinalCountCheck> responseVO = new ResponseVO<>();
        responseVO.setRows(byPage);
        responseVO.setTotal(allCount);
        return responseVO;
    }
    @RequestMapping("find")
    public String find(){
        return "f_count_check_list";
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String fCountCheckId, String note) {
        int i = finalCountCheckService.updateNote(fCountCheckId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        int i = finalCountCheckService.deleteByIds(ids);
        return ResponseMessage.getMessage(i);
    }






}
