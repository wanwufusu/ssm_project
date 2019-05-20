package com.ssm.controller.technology;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.technology.TechnologyPlan;
import com.ssm.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;
    @RequestMapping("find")
    public String find(){
        return "technologyPlan_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO list(Integer page, Integer rows){
        int offset = (page - 1) * rows;
        List<TechnologyPlan> technologies = technologyPlanService.findTechnologyPlan(rows,offset);
        if(technologies != null){
            for(TechnologyPlan technologyPlan:technologies){
                TechnologyPlan technologyPlan1 = technologyPlanService.getTechnology(technologyPlan);
                technologyPlan = technologyPlan1;
            }
        }
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null?0:technologies.size());
        return responseVO;
    }
    @RequestMapping("add")
    public String add(){
        return "technologyPlan_add";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public TechnologyPlan addJudge(){
        TechnologyPlan object = new TechnologyPlan();
        return object;
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(TechnologyPlan technologyPlan){
        HashMap<String,Object> insertTechnologyPlanResult = new HashMap<>();
        boolean flog = technologyPlanService.addTechnologyPlan(technologyPlan);
        if(flog){
            insertTechnologyPlanResult.put("status",200);
            insertTechnologyPlanResult.put("msg","OK");
            insertTechnologyPlanResult.put("data",null);
        }else {
            insertTechnologyPlanResult.put("status",404);
            insertTechnologyPlanResult.put("msg","fail");
            insertTechnologyPlanResult.put("data","insert fail");
        }
        return insertTechnologyPlanResult;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public TechnologyPlan editJudge(){
        return new TechnologyPlan();
    }
    @RequestMapping("edit")
    public String edit(){
        return "technologyPlan_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update(TechnologyPlan technologyPlan){
        boolean flag=technologyPlanService.editTechnologyPlan(technologyPlan);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","update fail");
        }
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public TechnologyPlan delete(){
        return new TechnologyPlan();
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delteteBatch(String ids){
        HashMap<String,Object> deleteTechnologyPlanResult = new HashMap<>();
        boolean flag =technologyPlanService.deleteTechnologyPlan(ids);
        if(flag){
            deleteTechnologyPlanResult.put("status",200);
            deleteTechnologyPlanResult.put("msg","OK");
            deleteTechnologyPlanResult.put("data","delete fail");
        }else {
            deleteTechnologyPlanResult.put("status",404);
            deleteTechnologyPlanResult.put("msg","fail");
            deleteTechnologyPlanResult.put("data","delete fail");
        }
        return deleteTechnologyPlanResult;
    }
    @RequestMapping("search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public ResponseVO searchByTechnologyId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<TechnologyPlan> technologies = technologyPlanService.findTechnologyPlanById(searchValue,rows,offset);
        if(technologies != null){
            for(TechnologyPlan technologyPlan:technologies){
                TechnologyPlan technologyPlan1 = technologyPlanService.getTechnology(technologyPlan);
                technologyPlan = technologyPlan1;
            }
        }
        ResponseVO<TechnologyPlan> responseVO = new ResponseVO<>();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null?0:technologies.size());
        return responseVO;
    }
    @RequestMapping("search_technologyPlan_by_technologyName")//search_technologyPlan_by_technologyName
    @ResponseBody
    public ResponseVO searchByTechnologyName(String searchValue,Integer page,Integer rows) {
        int offset = (page - 1) * rows;
        List<TechnologyPlan> technologies = technologyPlanService.findTechnologyPlanByName(searchValue, rows, offset);
        if(technologies != null){
            for(TechnologyPlan technologyPlan:technologies){
                TechnologyPlan technologyPlan1 = technologyPlanService.getTechnology(technologyPlan);
                technologyPlan = technologyPlan1;
            }
        }
        ResponseVO<TechnologyPlan> responseVO = new ResponseVO<>();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null ? 0 : technologies.size());
        return responseVO;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List<TechnologyPlan> getData(){
        List<TechnologyPlan> data = technologyPlanService.findPlan();
        if(data != null){
            for(TechnologyPlan technologyPlan : data){
                TechnologyPlan technologyPlan1 = technologyPlanService.getTechnology(technologyPlan);
                technologyPlan = technologyPlan1;
            }
        }
        return data;
    }
}
