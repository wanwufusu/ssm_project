package com.ssm.controller;

import com.ssm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/material")

public class materialController {

 @Autowired
    MaterialService materialService;

    @RequestMapping("/find")
    public String find(){
        return "material_list";

    }
    @RequestMapping("/list")
    @ResponseBody
    public List findMaterialList(Integer page,Integer rows){
        int offset = (page - 1) * rows;
        List materialList = materialService.findList(rows,offset);
        return materialList;
    }
}
