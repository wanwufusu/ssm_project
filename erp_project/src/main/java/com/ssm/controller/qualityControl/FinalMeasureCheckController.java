package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.FinalMeasuretCheck;
import com.ssm.service.qualityControl.FinalMeasureCheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/measure")
public class FinalMeasureCheckController {

    @Autowired
    FinalMeasureCheckService finalMeasureCheckService;
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

        List finalMeasureCheck = finalMeasureCheckService.findByPage(rows,offset);
        int allCount = finalMeasureCheckService.findAllCount();
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
        int i = finalMeasureCheckService.updateNote(fMeasureCheckId, note);
        return ResponseMessage.getMessage(i);
    }







    /**
     * 成品计量质检的添加按钮功能
     */
    @RequestMapping("add")
    public String add(){
        //todo
        return "measurement_add";
    }

    /**
     * 成品计量质检的编辑按钮功能
     */
    @RequestMapping("edit")
    public String edit(){
        //todo
        return "measurement_edit";
    }

    /**
     * 成品计量质检的删除选定功能
     * 返回list页面
     */
    @RequestMapping("delete_batch")
    public String delete_batch(){
        //todo
        return "/measure/list";
    }


}
