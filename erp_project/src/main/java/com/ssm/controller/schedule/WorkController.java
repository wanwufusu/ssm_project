package com.ssm.controller.schedule;

import com.ssm.bean.ResponseMessage;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/19
 * @since 1.0.0
 */
@Controller
@RequestMapping({"work","Work"})
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

    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public ResponseVO worksQueryById(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("workId", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Work> works = workService.queryPageWorkByWorkId(pageDetail, condition);
        ResponseVO<Work> responseVO = new ResponseVO<>();
        responseVO.setRows(works);
        responseVO.setTotal(workService.queryAllRecordByWorkId(condition));
        return responseVO;
    }

    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public ResponseVO worksQueryByWorkProduct(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("productName", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Work> works = workService.queryPageWorkByProductName(pageDetail, condition);
        ResponseVO<Work> responseVO = new ResponseVO<>();
        responseVO.setRows(works);
        responseVO.setTotal(workService.queryAllRecordByProductName(condition));
        return responseVO;
    }

    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public ResponseVO worksQueryByWorkDevice(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("deviceName", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Work> works = workService.queryPageWorkByDeviceName(pageDetail, condition);
        ResponseVO<Work> responseVO = new ResponseVO<>();
        responseVO.setRows(works);
        responseVO.setTotal(workService.queryAllRecordByDeviceName(condition));
        return responseVO;
    }

    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public ResponseVO worksQueryByWorkProcess(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("processId", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Work> works = workService.queryPageWorkByProcessId(pageDetail, condition);
        ResponseVO<Work> responseVO = new ResponseVO<>();
        responseVO.setRows(works);
        responseVO.setTotal(workService.queryAllRecordByProcessId(condition));
        return responseVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Work addJudge(){
        return new Work();
    }
    @RequestMapping("add")
    public String workAdd(){
        return "work_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage workInsert(Work work){
        int i = workService.insertWork(work);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "insert fail");
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Work deleteJudge(){
        return new Work();
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deleteWorks(String[] ids){
        int i = workService.deleteWorks(ids);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "delete fail");
        }
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Work editJudge(){
        return new Work();
    }

    @RequestMapping("edit")
    public String edit(){
        return "work_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage updateAll(Work updateWork){

        int i = workService.updateByWorkId(updateWork);

        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "fail", "update fail");
        }
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> workList(){
        return workService.queryWorks();
    }
}
