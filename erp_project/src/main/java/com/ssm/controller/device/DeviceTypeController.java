package com.ssm.controller.device;


import com.ssm.bean.device.*;
import com.ssm.service.device.DeviceTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("device/deviceType")
    public String deviceTypeList(Model model){
        return "deviceType";
    }


    @RequestMapping("deviceType/list")
    @ResponseBody
    public DeviceResponseVO device(Model model, DevicePage devicePage){
        devicePage.setOffset((devicePage.getPage()-1)*devicePage.getRows());
        DeviceResponseVO<DeviceType> deviceResponseVO = new DeviceResponseVO<>();
        int i = deviceTypeService.queryAllDeviceTypeRecord();
        deviceResponseVO.setTotal(i);
        List<DeviceType> deviceTypes = deviceTypeService.queryDeviceType(devicePage);
        deviceResponseVO.setRows(deviceTypes);
        return deviceResponseVO;
    }

    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceType/add")
    public String deviceTypeAdd(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public Map<String, Object> insertDeviceType(DeviceType deviceType){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        /*DeviceTypeMapResponseVO deviceTypeMapResponseVO = new DeviceTypeMapResponseVO();*/
        int i = deviceTypeService.insertDeviceType(deviceType);
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

    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("deviceType/edit")
    public String edit(){
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public Map<String, Object> updateDeviceType(DeviceType deviceType){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceTypeService.updateDeviceType(deviceType);
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

    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public String detate_judge(){
        return "";
    }


    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteDeviceType(String ids){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceTypeService.deleteDeviceType(ids);
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

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> getDataOfDeviceType(){
        return deviceTypeService.getDataOfDeviceType();
    }

}
