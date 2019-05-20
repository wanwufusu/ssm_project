package com.ssm.service.device.impl;

import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;
import com.ssm.mapper.device.DeviceMapper;
import com.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public List<Device> queryDevice(DevicePage devicePage) {
        int rows = devicePage.getRows();
        int offset = devicePage.getOffset();
        List<Device> devices = deviceMapper.queryAllDeviceByPage(offset,rows);
        return devices;
    }

    @Override
    public int findCount() {
        return deviceMapper.findCount();
    }

    /*@Override
    public int insertDeviceType(Device device) {
        return 0;
    }

    @Override
    public List<Device> getDataOfDevice() {
        return null;
    }*/
}
