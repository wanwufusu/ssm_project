package com.ssm.service.device.impl;


import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceType;
import com.ssm.bean.device.DeviceTypeExample;
import com.ssm.mapper.device.DeviceTypeMapper;
import com.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public List<DeviceType> queryDeviceType(DevicePage devicePage) {

        return null;
    }

    @Override
    public int queryAllDeviceTypeRecord() {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        return (int) deviceTypeMapper.countByExample(deviceTypeExample);
    }
}
