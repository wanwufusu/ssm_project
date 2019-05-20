package com.ssm.service.device.impl;

import com.ssm.bean.device.DeviceCheck;
import com.ssm.bean.device.DevicePage;
import com.ssm.mapper.device.DeviceCheckMapper;
import com.ssm.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    //jiekou
    @Override
    public List<DeviceCheck> getDataOfDeviceCheck() {
        return deviceCheckMapper.queryAllDeviceCheck();
    }

    @Override
    public int queryAllDeviceCheckRecord() {
        return deviceCheckMapper.queryAllDeviceCheckRecord();
    }

    public List<DeviceCheck> queryDeviceCheck(DevicePage devicePage) {
        int offset = devicePage.getOffset();
        int rows = devicePage.getRows();
        List<DeviceCheck> deviceChecks = deviceCheckMapper.queryAllDeviceCheckByPage(offset, rows);
        return deviceChecks;
    }


    @Override
    public int insertDeviceCheck(DeviceCheck deviceCheck) {
        return deviceCheckMapper.insertDeviceCheck(deviceCheck);
    }

    @Override
    public int deleteDeviceCheck(String ids) {
        return deviceCheckMapper.deleteDeviceCheck(ids);
    }

    @Override
    public int updateDeviceCheck(DeviceCheck deviceCheck) {
        return deviceCheckMapper.updateDeviceCheck(deviceCheck);
    }
}
