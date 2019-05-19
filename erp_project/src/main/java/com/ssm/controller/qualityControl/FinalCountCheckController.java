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
        ResponseMessage message = new ResponseMessage();
        int i = finalCountCheckService.updateNote(fCountCheckId, note);
        if (i == 1) {
            message.setMsg("ok");
            message.setData(null);
            message.setStatus(200);
            return message;
        } else {
            message.setMsg("not ok");
            message.setData(null);
            message.setStatus(400);
            return message;
        }
    }










    /**
     * 成品计数质检的添加
     * @return
     */
    @RequestMapping("insert")
    public String insert(){
        //todo
        return "f_count_check_add";
    }

    //事情没有这么简单
}
