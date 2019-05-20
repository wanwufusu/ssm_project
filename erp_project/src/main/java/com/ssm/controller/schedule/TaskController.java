package com.ssm.controller.schedule;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Task;
import com.ssm.service.schedule.TaskService;
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
 * @create 2019/5/20
 * @since 1.0.0
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("find")
    public String taskList(Model model){
        return "task_list";
    }

    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public ResponseVO tasksQueryById(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("taskId", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Task> tasks = taskService.queryPageTaskByTaskId(pageDetail, condition);
        ResponseVO<Task> responseVO = new ResponseVO<>();
        responseVO.setRows(tasks);
        responseVO.setTotal(taskService.queryAllRecordByTaskId(condition));
        return responseVO;
    }
    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public ResponseVO tasksQueryByWorkId(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("workId", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Task> tasks = taskService.queryPageTaskByWorkId(pageDetail, condition);
        ResponseVO<Task> responseVO = new ResponseVO<>();
        responseVO.setRows(tasks);
        responseVO.setTotal(taskService.queryAllRecordByWorkId(condition));
        return responseVO;
    }
    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public ResponseVO tasksQueryByManufactureSn(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("manufactureSn", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Task> tasks = taskService.queryPageTaskByManufactureSn(pageDetail, condition);
        ResponseVO<Task> responseVO = new ResponseVO<>();
        responseVO.setRows(tasks);
        responseVO.setTotal(taskService.queryAllRecordByManufactureSn(condition));
        return responseVO;
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO tasks(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Task> tasks = taskService.queryPageTask(pageDetail);
        ResponseVO<Task> responseVO = new ResponseVO<>();

        responseVO.setRows(tasks);
        responseVO.setTotal(taskService.queryAllTask());
        return responseVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Task addJudge(){
        return new Task();
    }
    @RequestMapping("add")
    public String taskAdd(){
        return "task_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage taskInsert(Task task){
        int i = taskService.insertTask(task);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "insert fail");
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Task deleteJudge(){
        return new Task();
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deleteTasks(String[] ids){
        int i = taskService.deleteTasks(ids);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "delete fail");
        }
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Task editJudge(){
        return new Task();
    }

    @RequestMapping("edit")
    public String edit(){
        return "task_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage updateAll(Task updateTask){

        int i = taskService.updateByTaskId(updateTask);

        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "fail", "update fail");
        }
    }
}
