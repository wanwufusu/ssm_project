package com.ssm.controller.qualityControl;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.FinalCountCheck;
import com.ssm.service.qualityControl.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("f_count_check")
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService service;
    /**
     * 成品计数质检的list及刷新
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<FinalCountCheck> list(Integer page,Integer rows){
        int offset= (page - 1) * rows;
        List<FinalCountCheck> byPage = service.findByPage(rows, offset);
        int allCount = service.findAllCount();
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
        int i = service.updateNote(fCountCheckId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        int i = service.deleteByIds(ids);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("/search_fCountCheck_by_{which}")
    @ResponseBody
    public ResponseVO likequery(@PathVariable("which")String which, String searchValue, Integer page, Integer rows){
        searchValue = "%"+searchValue+"%";
        String target =  which.replaceAll("[A-Z]", "_$0").toLowerCase();
        int offset = (page - 1) * rows;
        List list = service.searchList(target, searchValue, offset, rows);
        int allCount = service.searchAllCount(target, searchValue);
        ResponseVO<Object> vo = new ResponseVO<>();
        vo.setRows(list);
        vo.setTotal(allCount);
        return vo;
    }

    @RequestMapping("edit")
    public String edit(){
        return "f_count_check_edit";
    }

    @RequestMapping("add")
    public String add(){
        return "f_count_check_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage insert(FinalCountCheck fcc){
        return ResponseMessage.getMessage(3);

    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update_all(FinalCountCheck fcc){
        return ResponseMessage.getMessage(3);

    }


}
