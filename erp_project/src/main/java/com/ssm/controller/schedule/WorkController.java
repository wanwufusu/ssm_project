package com.ssm.controller.schedule;

import com.ssm.bean.ResponseVO;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;
import com.ssm.service.schedule.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("work")
public class WorkController {

    @Autowired
    WorkService workService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("find")
    public String workList(Model model){
        return "work_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO works(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Work> works = workService.queryPageWork(pageDetail);
        ResponseVO<Work> responseVO = new ResponseVO<>();

        responseVO.setRows(works);
        responseVO.setTotal(workService.queryAllWork());
        return responseVO;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> workList(){
        return workService.queryWorks();
    }
}
