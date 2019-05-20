package com.ssm.controller.technology;


import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.technology.Technology;
import com.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null?0:technologies.size());
        return responseVO;
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
    public ResponseMessage insert(Technology technology){
        boolean flog = technologyService.addTechnology(technology);
        if(flog){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","insert fail");
        }
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
    public ResponseMessage delteteBatch(String ids){
        boolean flag =technologyService.deleteTechnology(ids);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","delete fail");
        }
    }
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public ResponseVO searchByTechnologyId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Technology> technologies = technologyService.findTechnologyById(searchValue,rows,offset);
        ResponseVO<Technology> responseVO = new ResponseVO<>();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null?0:technologies.size());
        return responseVO;
    }
    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public ResponseVO searchByTechnologyName(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<Technology> technologies = technologyService.findTechnologyByName(searchValue,rows,offset);
        ResponseVO<Technology> responseVO = new ResponseVO<>();
        responseVO.setRows(technologies);
        responseVO.setTotal(technologies == null?0:technologies.size());
        return responseVO;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> data = technologyService.findAll();
        return data;
    }
    @RequestMapping("get/{technologyId}")
    @ResponseBody
    public Technology getDataById(@PathVariable("technologyId") String technologyId){
        return technologyService.findById(technologyId);
    }
}
