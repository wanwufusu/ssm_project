package com.ssm.controller.device;

import com.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping("deviceType")
    @ResponseBody

}
