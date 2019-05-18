package com.ssm.controller.qualityControl;

import com.ssm.service.qualityControl.impl.FinalMeasureCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/measure")
public class FinalMeasureCheckController {

    @Autowired
    FinalMeasureCheckServiceImpl finalMeasureCheckService;
    /**
     * 成品计量质检的刷新及list页面
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List list(Integer page,Integer rows){
        //todo
        int offset = (page - 1) * rows;
        List finalMeasureCheck = finalMeasureCheckService.findByPage(rows,offset);
        return finalMeasureCheck;
    }

 /*
        {"total":6,"rows":[
            {"fMeasureCheckId":"11069","orderId":"000009","checkItem":"??","cdate":1431518400000,"measureData":"36m","empId":"001","result":"?","note":"?????????","empName":"??"},
            {"fMeasureCheckId":"18969","orderId":"000013","checkItem":"文具","cdate":1431475200000,"measureData":"36m","empId":"001","result":"优","note":"?????????1","empName":"??"},
            {"fMeasureCheckId":"234","orderId":"00000111","checkItem":null,"cdate":1554523200000,"measureData":null,"empId":"6936","result":null,"note":"234","empName":"qwe"},
            {"fMeasureCheckId":"43253456","orderId":"00000111","checkItem":null,"cdate":1554523200000,"measureData":null,"empId":"6936","result":null,"note":null,"empName":"qwe"},
            {"fMeasureCheckId":"dsfds","orderId":"00000111","checkItem":"sdf","cdate":1554436800000,"measureData":"sd","empId":"002","result":"sdf","note":"sdf","empName":"??"},
            {"fMeasureCheckId":"ssss","orderId":"00000111","checkItem":null,"cdate":1554436800000,"measureData":null,"empId":"1","result":null,"note":null,"empName":"1"}
        ]}
*/

    /**
     * 来自home.jsp的list
     * @return
     */
    @RequestMapping("find")
    public String find(){
        return "forward:/measure/list";
    }

        //后面的玩意有判断功能,需要修改
    /**
     * 成品计量质检的添加按钮功能
     */
    @RequestMapping("add")
    public String add(){
        //todo
        return "measurement_add";
    }

    /**
     * 成品计量质检的编辑按钮功能
     */
    @RequestMapping("edit")
    public String edit(){
        //todo
        return "measurement_edit";
    }

    /**
     * 成品计量质检的删除选定功能
     * 返回list页面
     */
    @RequestMapping("delete_batch")
    public String delete_batch(){
        //todo
        return "/measure/list";
    }

    /**
     * 成品计量质检的给当前行添加备注功能
     */
    @RequestMapping("update_note")
    public String update_note(){
        //todo
        return "/measure/list";
    }


}
