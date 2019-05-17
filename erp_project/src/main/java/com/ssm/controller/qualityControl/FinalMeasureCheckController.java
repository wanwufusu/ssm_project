package com.ssm.controller.qualityControl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/measure")
public class FinalMeasureCheckController {

    /**
     * 成品计量质检的刷新及list页面
     * @return
     */
    @RequestMapping("list")
    public String list(){
        //todo
        return "p_measure_check_list";
    }
    @RequestMapping("find")
    public String find(){
        return "forward:/measure/list";
    }

        //后面的玩意有判断功能,需要修改
    /**
     * 成品计量质检的添加按钮功能
     */
    @RequestMapping("add")
    public String add(){
        //todo
        return "p_measure_check_add";
    }

    /**
     * 成品计量质检的编辑按钮功能
     */
    @RequestMapping("edit")
    public String edit(){
        //todo
        return "p_measure_check_edit";
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
