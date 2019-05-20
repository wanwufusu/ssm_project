package com.ssm.controller.MaterialController;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialVO;
import com.ssm.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {

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
        int count = materialService.findCount();
        MaterialVO<Material> materialVO = new MaterialVO<>();
        materialVO.setRows(materialList);
        materialVO.setTotal(count);
        return materialVO;
    }


    //权限
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    //跳转增加的页面
    @RequestMapping("/add")
    public String add(){
        return "material_add";
    }
    //插入操作
    @RequestMapping("/insert")
    @ResponseBody
    public ResponseMessage insert(Material material){
        ResponseMessage responseMessage = new ResponseMessage();
        Material material1 = materialService.selectMaterialById(material.getMaterialId());
        if(material1 != null){
            responseMessage.setStatus(404);
            responseMessage.setMsg("物料编号重复");
            return responseMessage;
        }else {
            if (materialService.insertMaterial(material) > 0) {
                responseMessage.setStatus(200);
                responseMessage.setMsg("插入成功");
            } else {
                responseMessage.setStatus(404);
                responseMessage.setMsg("插入失败");
            }
            return responseMessage;
        }
    }
    //查询material list
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> get(){
        List list = materialService.findAllMaterialList();
        return list;
    }

    //编辑页面
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String judge(){
        return "";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "material_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseMessage update(Material material){
        ResponseMessage responseMessage = new ResponseMessage();
        int result = materialService.updateMaterialById(material);
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
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseMessage delete_batch(String[] ids){
        ResponseMessage responseMessage = new ResponseMessage();
        int count = materialService.deleteBatch(ids);
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
    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public ResponseVO<Material> search(int page, int rows, String searchValue){
        ResponseVO<Material> responseVO = new ResponseVO<>();
        int offset = (page - 1) * rows;
        List<Material> list = materialService.searchMaterial(offset,rows,searchValue);
        int count = materialService.searchMaterialCount(searchValue);
        responseVO.setRows(list);
        responseVO.setTotal(count);
        return responseVO;
    }
    //根据Id 查询material rest风格？
    @RequestMapping("get/{materialId}")
    @ResponseBody
    public Material selectMaterialById(@PathVariable("materialId") String materialId){
        return materialService.selectMaterialById(materialId);
    }

    //更新备注
    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseMessage note(String materialId,String note){
        ResponseMessage responseMessage = new ResponseMessage();
        int count = materialService.updateNote(materialId,note);
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
