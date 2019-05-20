package com.ssm.controller.device;

import com.ssm.bean.ResponseVO;
import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceResponseVO;
import com.ssm.bean.device.DeviceType;
import com.ssm.service.device.DeviceService;
import org.springframework.ui.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller

public class DeviceController {
    @Autowired
    DeviceService deviceService;
    org.apache.log4j.Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("device/deviceList")
    public String deviceList(Model model){
        return "deviceList";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public DeviceResponseVO device(Model model, DevicePage devicePage){
        devicePage.setOffset((devicePage.getPage()-1)*devicePage.getRows());
        DeviceResponseVO<Device> deviceResponseVO = new DeviceResponseVO<>();
        int i = deviceService.findCount();
        deviceResponseVO.setTotal(i);
        List<Device> devices = deviceService.queryDevice(devicePage);
        deviceResponseVO.setRows(devices);
        return deviceResponseVO;
    }

    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceList/edit")
    public String deviceListEdit(){
        return "deviceList_edit";
    }


    @RequestMapping("deviceList/add")
    public String deviceAdd(){
        return "deviceList_add";
    }

    @RequestMapping("deviceList/insert")
    @ResponseBody
    public Map<String, Object> insertDevice(Device device){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceService.insertDevice(device);
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

    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public String detate_judge(){
        return "delete";
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteDevice(String ids){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceService.deleteDevice(ids);
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

    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getDataOfDevice(){
        return deviceService.getDataOfDevice();
    }

    @RequestMapping("deviceList/get/{deviceId}")
    @ResponseBody
    public Device queryDeviceById(@PathVariable("deviceId") String deviceId){
        return deviceService.queryDeviceByProductId(deviceId);
    }

    @RequestMapping("deviceList/update_all")
    @ResponseBody
    public Map<String, Object> updataDevice(Device device){
        LinkedHashMap<String, Object> objectObjectMap = new LinkedHashMap<>();
        int i = deviceService.updataDevice(device);
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

    //查询
    @RequestMapping("/deviceList/search_device_by_deviceId")
    @ResponseBody
    public DeviceResponseVO queryDeviceByDeviceId(String searchValue){

        System.out.println(searchValue);

        Device device = deviceService.queryDeviceByProductId(searchValue);
        DeviceResponseVO<Device> deviceResponseVO = new DeviceResponseVO<>();
        LinkedList<Device> devices = new LinkedList<>();
        devices.add(device);
        deviceResponseVO.setRows(devices);
        deviceResponseVO.setTotal(1);
        return deviceResponseVO;
    }


}
