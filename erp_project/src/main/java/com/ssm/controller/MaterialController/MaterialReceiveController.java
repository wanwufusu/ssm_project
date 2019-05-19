package com.ssm.controller.MaterialController;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.material.MaterialReceive;
import com.ssm.bean.material.MaterialVO;
import com.ssm.bean.material.Work;
import com.ssm.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;


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
        List materialReceiveList =  materialReceiveService.materialReceiveList(rows,offset);
        receiveMaterialVO.setRows(materialReceiveList);
        int count  = materialReceiveService.findReceiveCount();
        receiveMaterialVO.setTotal(count);
        return receiveMaterialVO;
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public String judge(){
        return "";
    }
    @RequestMapping("/add")

    public String add(){
        return "materialReceive_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public ResponseMessage add(MaterialReceive materialReceive){
        ResponseMessage responseMessage = new ResponseMessage();
        MaterialReceive materialReceive1 = materialReceiveService.selectMaterialReceiveById(materialReceive.getReceiveId());
        if(materialReceive1 != null){
            responseMessage.setStatus(404);
            responseMessage.setMsg("物料编号重复");
            return responseMessage;
        }else {
            if (materialReceiveService.insertMaterialReceive(materialReceive) > 0) {
                responseMessage.setStatus(200);
                responseMessage.setMsg("插入成功");
            } else {
                responseMessage.setStatus(404);
                responseMessage.setMsg("插入失败");
            }
            return responseMessage;
        }
    }

}
