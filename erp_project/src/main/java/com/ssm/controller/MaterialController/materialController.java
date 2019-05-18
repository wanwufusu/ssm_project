package com.ssm.controller.MaterialController;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import com.ssm.bean.material.MaterialVO;
import com.ssm.service.material.MaterialService;
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

    //动态跳转list页面
    @RequestMapping("/find")
    public String find(){
        return "material_list";

    }
    //查询物料list
    @RequestMapping("/list")
    @ResponseBody
    public MaterialVO<Material> findMaterialList(int page, int rows){
        int offset = (page - 1) * rows;
        List materialList = materialService.findList(rows,offset);
        MaterialVO<Material> materialVO = new MaterialVO<>();
        materialVO.setRows(materialList);
        materialVO.setTotal(materialList.size());
        return materialVO;
    }
    //动态跳转receive页面
    @RequestMapping("/receive")
    public String findMaterialReceive(){
        return "materialReceive_list";
    }
    //查询receiveList页面
    @RequestMapping("/receiveList")
    @ResponseBody
    public MaterialVO<MaterialReceive> findReceive(int page, int rows){
        MaterialVO<MaterialReceive> receiveMaterialVO = new MaterialVO<>();
        int offset = (page - 1) * rows;
        List materialReceiveList =  materialService.materialReceiveList(rows,offset);
        receiveMaterialVO.setRows(materialReceiveList);
        receiveMaterialVO.setTotal(materialReceiveList.size());
        return receiveMaterialVO;
    }
}
