package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.FinalMeasuretCheck;
import com.ssm.service.qualityControl.FinalMeasureCheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/measure")
public class FinalMeasureCheckController {

    @Autowired
    FinalMeasureCheckService service;
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 成品计量质检的刷新及list页面
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<FinalMeasuretCheck> list(Integer page, Integer rows){
        //todo
        int offset = (page - 1) * rows;

        List finalMeasureCheck = service.findByPage(rows,offset);
        int allCount = service.findAllCount();
        ResponseVO<FinalMeasuretCheck> vo = new ResponseVO<>();
        vo.setRows(finalMeasureCheck);
        vo.setTotal(allCount);
        return vo;
    }

    /**
     * 来自home.jsp的list
     * @return
     */
    @RequestMapping("find")
    public String find(){
        return "measurement_list";
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String fMeasureCheckId, String note){
        int i = service.updateNote(fMeasureCheckId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        int i = service.deleteByIds(ids);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("/search_fMeasureCheck_by_{which}")
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







}
