package com.ssm.controller.MaterialController;

import com.ssm.bean.material.MaterialConsume;
import com.ssm.bean.material.MaterialVO;
import com.ssm.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    @RequestMapping("/find")
    public String find(){
        return "materialConsume_list";
    }
    @RequestMapping("/list")
    public MaterialVO findList(){
        MaterialVO<MaterialConsume> consumeMaterialVO = new MaterialVO<>();

        return consumeMaterialVO;
    }
}
