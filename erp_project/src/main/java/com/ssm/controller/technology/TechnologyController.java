package com.ssm.controller.technology;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.technology.Technology;
import com.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;
    @RequestMapping("find")
    public String find(){
        return "technology_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO list(Integer page, Integer rows){
        int offset = (page - 1) * rows;
        List<Technology> technologies = technologyService.findTechnology(rows,offset);
        ResponseVO ResponseVO = new ResponseVO();
        ResponseVO.setRows(technologies);
        ResponseVO.setTotal(technologies == null?0:technologies.size());
        return ResponseVO;
    }
    @RequestMapping("add")
    public String add(){
        return "technology_add";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public Technology addJudge(){
        Technology object = new Technology();
        return object;
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Technology technology){
        HashMap<String,Object> insertTechnologyResult = new HashMap<>();
        boolean flog = technologyService.addTechnology(technology);
        if(flog){
            insertTechnologyResult.put("status",200);
            insertTechnologyResult.put("msg","OK");
            insertTechnologyResult.put("data",null);
        }else {
            insertTechnologyResult.put("status",404);
            insertTechnologyResult.put("msg","fail");
            insertTechnologyResult.put("data","insert fail");
        }
        return insertTechnologyResult;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Technology editJudge(){
        return new Technology();
    }
    @RequestMapping("edit")
    public String edit(){
        return "technology_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update(Technology technology){
        boolean flag=technologyService.editTechnology(technology);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","update fail");
        }
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public Technology delete(){
        return new Technology();
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delteteBatch(String ids){
        HashMap<String,Object> deleteTechnologyResult = new HashMap<>();
        boolean flag =technologyService.deleteTechnology(ids);
        if(flag){
            deleteTechnologyResult.put("status",200);
            deleteTechnologyResult.put("msg","OK");
            deleteTechnologyResult.put("data","delete fail");
        }else {
            deleteTechnologyResult.put("status",404);
            deleteTechnologyResult.put("msg","fail");
            deleteTechnologyResult.put("data","delete fail");
        }
        return deleteTechnologyResult;
    }
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public ResponseVO searchByTechnologyId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Technology> technologies = technologyService.findTechnologyById(searchValue,rows,offset);
        ResponseVO<Technology> ResponseVO = new ResponseVO<>();
        ResponseVO.setRows(technologies);
        ResponseVO.setTotal(technologies == null?0:technologies.size());
        return ResponseVO;
    }
    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public ResponseVO searchByTechnologyName(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Technology> technologies = technologyService.findTechnologyByName(searchValue,rows,offset);
        ResponseVO<Technology> ResponseVO = new ResponseVO<>();
        ResponseVO.setRows(technologies);
        ResponseVO.setTotal(technologies == null?0:technologies.size());
        return ResponseVO;
    }

}
