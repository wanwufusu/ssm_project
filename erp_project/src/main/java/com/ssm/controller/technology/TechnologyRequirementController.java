package com.ssm.controller.technology;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.technology.Technology;
import com.ssm.bean.technology.TechnologyRequirement;
import com.ssm.service.technology.TechnologyRequirementService;
import com.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;
    @Autowired
    TechnologyService technologyService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> data = technologyService.findAll();
        return data;
    }
    @RequestMapping("find")
    public String find(){
        return "technologyRequirement_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO list(Integer page, Integer rows){
        int offset = (page - 1) * rows;
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.findTechnologyRequirement(rows,offset);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(technologyRequirements);
        responseVO.setTotal(technologyRequirements == null?0:technologyRequirements.size());
        return responseVO;
    }
    @RequestMapping("add")
    public String add(){
        return "technologyRequirement_add";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public TechnologyRequirement addJudge(){
        TechnologyRequirement object = new TechnologyRequirement();
        return object;
    }
    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage insert(TechnologyRequirement technologyRequirement){
        boolean flag = technologyRequirementService.addTechnologyRequirement(technologyRequirement);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","insert fail");
        }
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public TechnologyRequirement editJudge(){
        return new TechnologyRequirement();
    }
    @RequestMapping("edit")
    public String edit(){
        return "technologyRequirement_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update(TechnologyRequirement technologyRequirement){
        boolean flag = technologyRequirementService.editTechnologyRequirement(technologyRequirement);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","update fail");
        }
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public TechnologyRequirement delete(){
        return new TechnologyRequirement();
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deletebatch(String ids){
        boolean flag = technologyRequirementService.deleteTechnologyRequirement(ids);
        if(flag){
            return new ResponseMessage(200,"OK",null);
        }else{
            return new ResponseMessage(404,"fail","delete fail");
        }
    }
    @RequestMapping("search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public ResponseVO searchByTechnologyRequirementId(String searchValue,Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.findTechnologyRequirementById(searchValue,rows,offset);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(technologyRequirements);
        responseVO.setTotal(technologyRequirements == null?0:technologyRequirements.size());
        return responseVO;
    }
    @RequestMapping("search_technologyRequirement_by_technologyName")
    @ResponseBody
    public ResponseVO searchByTechnologyName(String searchValue,Integer pge,Integer rows){
        int offset = (pge - 1) * rows;
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.findTechnologyRequirementByName(searchValue,rows,offset);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setRows(technologyRequirements);
        responseVO.setTotal(technologyRequirements == null?0:technologyRequirements.size());
        return responseVO;
    }
}
