package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.ProcessMeasureCheck;
import com.ssm.service.qualityControl.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_measure_check")
public class ProcessMeasureCheckController{

    @Autowired
    ProcessMeasureCheckService service;

    @RequestMapping("find")
    public String find(){
        return "p_measure_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<ProcessMeasureCheck> list(Integer page,Integer rows){
        int offset = (page -1) * rows;
        int allCount = service.findAllCount();
        List<ProcessMeasureCheck> list = service.findByPage(rows, offset);
        ResponseVO<ProcessMeasureCheck> vo = new ResponseVO<ProcessMeasureCheck>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }
    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String pMeasureCheckId, String note) {
        int i = service.updateNote(pMeasureCheckId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        int i = service.deleteByIds(ids);
        return ResponseMessage.getMessage(i);
    }
    @RequestMapping("/search_pMeasureCheck_by_{which}")
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
        return "p_measure_check_edit";
    }

    @RequestMapping("add")
    public String add(){
        return "p_measure_check_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage insert(ProcessMeasureCheck pmc){
        return ResponseMessage.getMessage(3);

    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update_all(ProcessMeasureCheck pmc){
        return ResponseMessage.getMessage(3);

    }
}