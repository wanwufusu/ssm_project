package com.ssm.controller.device;


import com.ssm.bean.device.DeviceFault;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceResponseVO;
import com.ssm.service.device.DeviceFaultService;
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
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("device/deviceFault")
    public String deviceFault(Model model){
        return "deviceFault";
    }

    @RequestMapping("deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> getDataOfDeviceFault(){
        return deviceFaultService.getDataOfDeviceFault();
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public DeviceResponseVO deviceFault(Model model, DevicePage devicePage){
        devicePage.setOffset((devicePage.getPage()-1)*devicePage.getRows());
        DeviceResponseVO<DeviceFault> deviceResponseVO = new DeviceResponseVO<>();
        int i = deviceFaultService.queryAllDeviceFaultRecord();
        deviceResponseVO.setTotal(i);
        List<DeviceFault> deviceFaults = deviceFaultService.queryDeviceFault(devicePage);
        deviceResponseVO.setRows(deviceFaults);
        return deviceResponseVO;
    }
    @RequestMapping("deviceFault/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceFault/add")
    public String deviceFaultAdd(){
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public Map<String, Object> insertDeviceFault(DeviceFault deviceFault){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceFaultService.insertDeviceFault(deviceFault);
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
    @RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("deviceFault/edit")
    public String deviceFaultEdit(){
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    @ResponseBody
    public Map<String, Object> updateDeviceFault(DeviceFault deviceFault){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceFaultService.updateDeviceFault(deviceFault);
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
    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }


    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteDeviceFault(String ids){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceFaultService.deleteDeviceFault(ids);
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
