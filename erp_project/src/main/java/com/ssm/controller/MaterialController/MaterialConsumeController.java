package com.ssm.controller.MaterialController;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialConsume;
import com.ssm.bean.material.MaterialVO;

import com.ssm.bean.schedule.Work;
import com.ssm.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    //动态跳转list页面
    @RequestMapping("materialConsume/find")
    public String find(){
        return "materialConsume_list";
    }
    //分页查询list
    @RequestMapping("materialConsume/list")
    @ResponseBody
    public MaterialVO findList(int page,int rows){
        int offset = (page - 1) *rows;
        MaterialVO<MaterialConsume> consumeMaterialVO = new MaterialVO<>();
        int count  = materialConsumeService.queryCount();
        List list = materialConsumeService.selectListByPage(offset,rows);
        consumeMaterialVO.setTotal(count);
        consumeMaterialVO.setRows(list);
        return consumeMaterialVO;
    }

    //插入操作
    @RequestMapping("MaterialConsume/add_judge")
    @ResponseBody
    public String judge(){
        return "";
    }
    @RequestMapping("materialConsume/add")
    public String add(){
        return "materialConsume_add";
    }
    @RequestMapping("MaterialConsume/insert")
    @ResponseBody
    public ResponseMessage insert(MaterialConsume materialConsume){
        ResponseMessage responseMessage = new ResponseMessage();
        MaterialConsume materialConsume1 = materialConsumeService.selectMaterialConsumeById(materialConsume.getConsumeId());
        if(materialConsume1 != null){
            responseMessage.setStatus(404);
            responseMessage.setMsg("物料编号重复");
            return responseMessage;
        }else {
            if (materialConsumeService.insertMaterialConsume(materialConsume) > 0) {
                responseMessage.setStatus(200);
                responseMessage.setMsg("插入成功");
            } else {
                responseMessage.setStatus(404);
                responseMessage.setMsg("插入失败");
            }
            return responseMessage;
        }
    }


    //删除操作
    @RequestMapping("MaterialConsume/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }
    @RequestMapping("MaterialConsume/delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        ResponseMessage responseMessage = new ResponseMessage();
        int count = materialConsumeService.deleteBatch(ids);
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
    @RequestMapping("MaterialConsume/search_materialConsume_by_consumeId")
    @ResponseBody
    public ResponseVO<MaterialConsume> search(int page, int rows, String searchValue){
        ResponseVO<MaterialConsume> responseVO = new ResponseVO<>();
        int offset = (page - 1) * rows;
        List<MaterialConsume> list = materialConsumeService.searchMaterialConsume(offset,rows,searchValue);
        int count = materialConsumeService.searchMaterialConsumeCount(searchValue);
        responseVO.setRows(list);
        responseVO.setTotal(count);
        return responseVO;
    }
}
