package com.ssm.service.device.impl;


import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceType;
import com.ssm.bean.device.DeviceTypeExample;
import com.ssm.mapper.device.DeviceTypeMapper;
import com.ssm.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public List<DeviceType> queryDeviceType(DevicePage devicePage) {
        int rows = devicePage.getRows();
        int offset = devicePage.getOffset();

        List<DeviceType> deviceTypes = deviceTypeMapper.queryAllDeviceTypeByPage(offset,rows);
        return deviceTypes;
    }

    @Override
    public int queryAllDeviceTypeRecord() {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        return (int) deviceTypeMapper.countByExample(deviceTypeExample);
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        return deviceTypeMapper.insertDeviceType(deviceType);
    }

    //deviceType的get data
    @Override
    public List<DeviceType> getDataOfDeviceType() {
        List<DeviceType> deviceTypes = deviceTypeMapper.queryAllDeviceType();
        return deviceTypes;
    }

    @Override
    public int updateDeviceType(DeviceType deviceType) {
        return deviceTypeMapper.updateDeviceType(deviceType);
    }

    @Override
    public int deleteDeviceType(String ids) {
        return deviceTypeMapper.deleteDeviceType(ids);
    }

    @Override
    public DeviceType getDeviceTypeById(String id) {
        return deviceTypeMapper.queryDeviceTypeById(id);
    }
}
