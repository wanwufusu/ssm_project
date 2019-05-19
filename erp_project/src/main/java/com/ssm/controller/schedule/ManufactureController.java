package com.ssm.controller.schedule;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.schedule.Manufacture;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.service.schedule.ManufactureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/20
 * @since 1.0.0
 */
@Controller
@RequestMapping({"manufacture","Manufacture"})
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("find")
    public String manufactureList(Model model){
        return "manufacture_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO manufactures(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Manufacture> manufactures = manufactureService.queryPageManufacture(pageDetail);
        ResponseVO<Manufacture> responseVO = new ResponseVO<>();

        responseVO.setRows(manufactures);
        responseVO.setTotal(manufactureService.queryAllManufacture());
        return responseVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Manufacture addJudge(){
        return new Manufacture();
    }
    @RequestMapping("add")
    public String manufactureAdd(){
        return "manufacture_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage manufactureInsert(Manufacture manufacture){
        int i = manufactureService.insertManufacture(manufacture);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "insert fail");
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Manufacture deleteJudge(){
        return new Manufacture();
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deleteManufactures(String[] ids){
        int i = manufactureService.deleteManufactures(ids);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "delete fail");
        }
    }
    
    @RequestMapping("edit_judge")
    @ResponseBody
    public Manufacture editJudge(){
        return new Manufacture();
    }

    @RequestMapping("edit")
    public String edit(){
        return "manufacture_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage updateAll(Manufacture updateManufacture){

        int i = manufactureService.updateByManufactureId(updateManufacture);

        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "fail", "update fail");
        }
    }
}
