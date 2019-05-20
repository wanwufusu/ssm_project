package com.ssm.controller.device;


import com.ssm.bean.device.DeviceMaintain;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceResponseVO;
import com.ssm.service.device.DeviceMaintainService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain(Model model){
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/get_data")
    @ResponseBody
    public List<DeviceMaintain> getDataOfDeviceMaintain(){
        return deviceMaintainService.getDataOfDeviceMaintain();
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public DeviceResponseVO deviceMaintain(Model model, DevicePage devicePage){
        devicePage.setOffset((devicePage.getPage()-1)*devicePage.getRows());
        DeviceResponseVO<DeviceMaintain> deviceResponseVO = new DeviceResponseVO<>();
        int i = deviceMaintainService.queryAllDeviceMaintainRecord();
        deviceResponseVO.setTotal(i);
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.queryDeviceMaintain(devicePage);
        deviceResponseVO.setRows(deviceMaintains);
        return deviceResponseVO;
    }
    @RequestMapping("deviceMaintain/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceMaintain/add")
    public String deviceMaintainAdd(){
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public Map<String, Object> insertDeviceMaintain(DeviceMaintain deviceMaintain){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceMaintainService.insertDeviceMaintain(deviceMaintain);
        if(i==1){
            objectObjectMap.put("status",200);
            objectObjectMap.put("msg","OK");
            objectObjectMap.put("data",null);
        }else{
            objectObjectMap.put("status",0);
            objectObjectMap.put("msg","该设备种类编号已经存在，请更换设备种类编号！");
            objectObjectMap.put("data",null);
        }
        return objectObjectMap;
    }

    //更新
    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("deviceMaintain/edit")
    public String deviceMaintainEdit(){
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public Map<String, Object> updateDeviceMaintain(DeviceMaintain deviceMaintain){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceMaintainService.updateDeviceMaintain(deviceMaintain);
        if(i==1){
            objectObjectMap.put("status",200);
            objectObjectMap.put("msg","OK");
            objectObjectMap.put("data",null);
        }else{
            objectObjectMap.put("status",0);
            objectObjectMap.put("msg","更新失败！");
            objectObjectMap.put("data",null);
        }

        return objectObjectMap;
    }
    /*删除---------------------------------------------------------------------*/
    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }


    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteDeviceMaintain(String ids){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceMaintainService.deleteDeviceMaintain(ids);
        if(i==1){
            objectObjectMap.put("status",200);
            objectObjectMap.put("msg","OK");
            objectObjectMap.put("data",null);
        }else{
            objectObjectMap.put("status",0);
            objectObjectMap.put("msg","删除失败！");
            objectObjectMap.put("data",null);
        }

        return objectObjectMap;
    }




}
