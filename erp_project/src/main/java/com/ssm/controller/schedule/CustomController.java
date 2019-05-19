package com.ssm.controller.schedule;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.schedule.Custom;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.service.schedule.CustomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomService customService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("find")
    public String customList(Model model){
        return "custom_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO custom(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        //List<Custom> customs = customService.queryPageCustom();
        List<Custom> customs = customService.queryPageCustom(pageDetail);
        ResponseVO<Custom> ResponseVO = new ResponseVO<>();

        ResponseVO.setRows(customs);
        ResponseVO.setTotal(customService.queryAllRecord());
        return ResponseVO;
    }
    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public ResponseVO customQueryById(Model model, PageDetail pageDetail, String searchValue){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Custom> customs = customService.queryPageCustomByCustomId(pageDetail, searchValue);
        ResponseVO<Custom> ResponseVO = new ResponseVO<>();

        ResponseVO.setRows(customs);
        ResponseVO.setTotal(customService.queryAllRecordByCustomId(searchValue));
        return ResponseVO;
    }
    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public ResponseVO customQueryByName(Model model, PageDetail pageDetail, String searchValue){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Custom> customs = customService.queryPageCustomBycustomName(pageDetail, searchValue);
        ResponseVO<Custom> ResponseVO = new ResponseVO<>();

        ResponseVO.setRows(customs);
        ResponseVO.setTotal(customService.queryAllRecordBycustomName(searchValue));
        return ResponseVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Custom addJudge(){
        Custom object = new Custom();
        return object;
    }

    @RequestMapping("add")
    public String customAdd(){
        return "custom_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map customInsert(Custom custom){
        HashMap<String, Object> insertCustomResult = new HashMap<>();
        int i = customService.insertCustom(custom);
        if (i > 0) {
            insertCustomResult.put("status", 200);
            insertCustomResult.put("msg", "OK");
            insertCustomResult.put("data", null);
        } else {
            insertCustomResult.put("status", 404);
            insertCustomResult.put("msg", "fail");
            insertCustomResult.put("data", "insert fail");
        }
        return insertCustomResult;
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Custom deleteJudge(){
        return new Custom();
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map deleteCustom(int ids){
        HashMap<String, Object> deleteCustomResult = new HashMap<>();
        int i = customService.deleteCustom(Integer.toString(ids));
        if (i > 0) {
            deleteCustomResult.put("status", 200);
            deleteCustomResult.put("msg", "OK");
            deleteCustomResult.put("data", null);
        } else {
            deleteCustomResult.put("status", 404);
            deleteCustomResult.put("msg", "fail");
            deleteCustomResult.put("data", "delete fail");
        }
        return deleteCustomResult;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Custom editJudge(){
        return new Custom();
    }

    @RequestMapping("edit")
    public String edit(){
        return "custom_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage updateAll(Custom updateCustom){

        ResponseMessage responseMessage;

        int i = customService.updateByCustomId(updateCustom);

        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "fail", "update fail");
        }
    }
}
