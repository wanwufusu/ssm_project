package com.ssm.service.device.impl;

import com.ssm.bean.device.DeviceMaintain;
import com.ssm.bean.device.DevicePage;
import com.ssm.mapper.device.DeviceMaintainMapper;
import com.ssm.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> getDataOfDeviceMaintain() {
        return deviceMaintainMapper.queryAllDeviceMaintain();
    }

    @Override
    public int queryAllDeviceMaintainRecord() {
        return deviceMaintainMapper.queryAllDeviceMaintainRecord();
    }

    @Override
    public List<DeviceMaintain> queryDeviceMaintain(DevicePage devicePage) {
        int rows = devicePage.getRows();
        int offset = devicePage.getOffset();
        return deviceMaintainMapper.queryAllDeviceMaintainByPage(offset,rows);
    }

    @Override
    public int insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainMapper.insertDeviceMaintain(deviceMaintain);
    }

    @Override
    public int deleteDeviceMaintain(String ids) {
        return deviceMaintainMapper.deleteDeviceMaintain(ids);
    }

    @Override
    public int updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainMapper.updateDeviceMaintain(deviceMaintain);
    }
}
