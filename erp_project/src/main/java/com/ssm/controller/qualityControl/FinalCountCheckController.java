package com.ssm.controller.qualityControl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/f_count_check")
public class FinalCountCheckController {


    /**
     * 成品计数质检的list及刷新
     * @return
     */
    @RequestMapping("list")
    public String list(){
        //todo
        return "f_count_check_list";
    }
    @RequestMapping("find")
    public String find(){
        return "forward:/f_count_check/list";
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
