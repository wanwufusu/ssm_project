package com.ssm.controller.technology;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.technology.Process;
import com.ssm.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> getData(){
        List<Process> data = processService.findAll();
        return data;
    }
    @RequestMapping("get/{processId}")
    @ResponseBody
    public Process getDataById(@PathVariable("processId") String processId){
        Process data = processService.findById(processId);
        return data;
    }
    @RequestMapping("find")
    public String find(){
        return "process_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO list(Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Process> processes = processService.findProcess(rows,offset);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(processes);
        responseVO.setTotal(processes == null?0:processes.size());
        return responseVO;
    }
    @RequestMapping("add")
    public String add(){
        return "process_add";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public Process addJudge(){
        Process object = new Process();
        return object;
    }
    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage insert(Process process){
        boolean flag = processService.addProcess(process);
        if(flag){
            return new ResponseMessage(200,"Ok",null);
        }else {
            return new ResponseMessage(404,"fail","insert fail");
        }
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Process editJudge(){
        return new Process();
    }
    @RequestMapping("edit")
    public String edit(){
        return "process_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update(Process process){
        boolean flag = processService.editProcess(process);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else {
            return new ResponseMessage(404,"fail","update fail");
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Process delete(){
        return new Process();
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deleteBatch(String ids){
        boolean flag = processService.deleteProcess(ids);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else {
            return new ResponseMessage(404,"fail","delete fail");
        }
    }
    @RequestMapping("search_process_by_processId")
    @ResponseBody
    public ResponseVO searchByProcessId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Process> processes = processService.findProcessById(searchValue,rows,offset);
        ResponseVO<Process> responseVO = new ResponseVO<>();
        responseVO.setTotal(processes == null?0:processes.size());
        responseVO.setRows(processes);
        return responseVO;
    }
    @RequestMapping("search_process_by_technologyPlanId")
    @ResponseBody
    public ResponseVO searchByTechnologyPlanId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Process> processes = processService.findProcessByTid(searchValue,rows,offset);
        ResponseVO<Process> responseVO = new ResponseVO<>();
        responseVO.setTotal(processes == null?0:processes.size());
        responseVO.setRows(processes);
        return responseVO;
    }
}
