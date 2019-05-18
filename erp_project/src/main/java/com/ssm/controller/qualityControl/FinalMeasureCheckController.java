package com.ssm.controller.qualityControl;

import com.ssm.bean.qualityControl.FMCVo;
import com.ssm.service.qualityControl.impl.FinalMeasureCheckServiceImpl;
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
    FinalMeasureCheckServiceImpl finalMeasureCheckService;
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 成品计量质检的刷新及list页面
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public FMCVo list(Integer page, Integer rows){
        //todo
        int offset = (page - 1) * rows;

        List finalMeasureCheck = finalMeasureCheckService.findByPage(rows,offset);
        int allCount = finalMeasureCheckService.findAllCount();
        FMCVo fmcVo = new FMCVo();
        fmcVo.setRows(finalMeasureCheck);
        fmcVo.setTotal(allCount);
        return fmcVo;
    }



    /**
     * 来自home.jsp的list
     * @return
     */
    @RequestMapping("find")
    public String find(){
        return "measurement_list";
    }

        //后面的玩意有判断功能,需要修改
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

    /**
     * 成品计量质检的给当前行添加备注功能
     */
    @RequestMapping("update_note")
    public String update_note(){
        //todo
        return "/measure/list";
    }


}
