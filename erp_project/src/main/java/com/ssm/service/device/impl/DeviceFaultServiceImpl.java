package com.ssm.service.device.impl;

import com.ssm.bean.device.DeviceFault;
import com.ssm.bean.device.DevicePage;
import com.ssm.mapper.device.DeviceFaultMapper;
import com.ssm.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    //接口
    @Override
    public List<DeviceFault> getDataOfDeviceFault() {
        return deviceFaultMapper.queryAllDeviceFault();
    }

    @Override
    public int queryAllDeviceFaultRecord() {
        return deviceFaultMapper.queryAllDeviceFaultRecord();
    }

    @Override
    public List<DeviceFault> queryDeviceFault(DevicePage devicePage) {
        int rows = devicePage.getRows();
        int offset = devicePage.getOffset();
        List<DeviceFault> deviceFaults = deviceFaultMapper.queryAllDeviceFaultByPage(offset, rows);
        return deviceFaults;
    }

    @Override
    public int insertDeviceFault(DeviceFault deviceFault) {
        return deviceFaultMapper.insertDeviceFault(deviceFault);
    }

    @Override
    public int deleteDeviceFault(String ids) {
        return deviceFaultMapper.deleteDeviceFault(ids);
    }

    @Override
    public int updateDeviceFault(DeviceFault deviceFault) {
        return deviceFaultMapper.updateDeviceFault(deviceFault);
    }
}
