package com.ssm.controller.MaterialController;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.material.MaterialReceive;
import com.ssm.bean.material.MaterialVO;
import com.ssm.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;


    @RequestMapping("materialReceive/receive")
    public String findMaterialReceive(){
        return "materialReceive_list";
    }

    //查询receiveList页面
    @RequestMapping("materialReceive/receiveList")
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

    //插入操作
    @RequestMapping("materialReceive/add_judge")
    @ResponseBody
    public String judge(){
        return "";
    }

    @RequestMapping("materialReceive/add")
    public String add(){
        return "materialReceive_add";
    }

    @RequestMapping("materialReceive/insert")
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
    //编辑操作
    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }

    @RequestMapping("materialReceive/edit")
    public String edit(){
        return "materialReceive_edit";
    }

    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public ResponseMessage update(MaterialReceive materialReceive){
        ResponseMessage responseMessage = new ResponseMessage();
        int result = materialReceiveService.updateMaterialReceiveById(materialReceive);
        if(result > 0){
            responseMessage.setStatus(200);
            responseMessage.setMsg("修改成功");
        }else {
            responseMessage.setStatus(404);
            responseMessage.setMsg("修改失败");
        }
        return responseMessage;
    }

    //删除操作
    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String delete(){
        return "";
    }
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        ResponseMessage responseMessage = new ResponseMessage();
        int count = materialReceiveService.deleteBatch(ids);
        if(count > 0){
            responseMessage.setStatus(200);
            responseMessage.setMsg("删除成功");
        }else{
            responseMessage.setStatus(404);
            responseMessage.setMsg("删除失败");
        }
        return responseMessage;
    }

    //模糊查询
    @RequestMapping("materialReceive/search_materialReceive_by_receiveId")
    @ResponseBody
    public ResponseVO<MaterialReceive> search(int page, int rows, String searchValue){
        ResponseVO<MaterialReceive> responseVO = new ResponseVO<>();
        int offset = (page - 1) * rows;
        List<MaterialReceive> list = materialReceiveService.searchMaterialReceive(offset,rows,searchValue);
        int count = materialReceiveService.searchMaterialReceiveCount(searchValue);
        responseVO.setRows(list);
        responseVO.setTotal(count);
        return responseVO;
    }


    //更新备注
    @RequestMapping("materialReceive/update_note")
    @ResponseBody
    public ResponseMessage note(String receiveId,String note){
        ResponseMessage responseMessage = new ResponseMessage();
        int count = materialReceiveService.updateNote(receiveId,note);
        if(count > 0){
            responseMessage.setStatus(200);
            responseMessage.setMsg("修改成功");
        }else{
            responseMessage.setStatus(404);
            responseMessage.setMsg("修改失败");
        }
        return responseMessage;
    }


}
