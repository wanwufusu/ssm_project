package com.ssm.controller.device;

import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceResponseVO;
import com.ssm.bean.device.DeviceType;
import com.ssm.service.device.DeviceService;
import org.springframework.ui.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
