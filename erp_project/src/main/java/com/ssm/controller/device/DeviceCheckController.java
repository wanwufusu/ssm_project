package com.ssm.controller.device;


import com.ssm.bean.device.DeviceCheck;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceResponseVO;
import com.ssm.service.device.DeviceCheckService;
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
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("device/deviceCheck")
    public String deviceCheck(Model model){
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/get_data")
    @ResponseBody
    public List<DeviceCheck> getDataOfDeviceFault(){
        return deviceCheckService.getDataOfDeviceCheck();
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public DeviceResponseVO deviceCheck(Model model, DevicePage devicePage){
        devicePage.setOffset((devicePage.getPage()-1)*devicePage.getRows());
        DeviceResponseVO<DeviceCheck> deviceResponseVO = new DeviceResponseVO<>();
        int i = deviceCheckService.queryAllDeviceCheckRecord();
        deviceResponseVO.setTotal(i);
        List<DeviceCheck> deviceFaults = deviceCheckService.queryDeviceCheck(devicePage);
        deviceResponseVO.setRows(deviceFaults);
        return deviceResponseVO;
    }
    @RequestMapping("deviceCheck/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceCheck/add")
    public String deviceCheckAdd(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public Map<String, Object> insertDeviceCheck(DeviceCheck deviceCheck){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceCheckService.insertDeviceCheck(deviceCheck);
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
    @RequestMapping("deviceCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("deviceCheck/edit")
    public String deviceCheckEdit(){
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public Map<String, Object> updateDeviceCheck(DeviceCheck deviceCheck){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceCheckService.updateDeviceCheck(deviceCheck);
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
    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }


    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteDeviceCheck(String ids){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceCheckService.deleteDeviceCheck(ids);
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

