package com.ssm.service.device;

import com.ssm.bean.device.DeviceFault;
import com.ssm.bean.device.DevicePage;

import java.util.List;

public interface DeviceFaultService {
    List<DeviceFault> getDataOfDeviceFault();

    int queryAllDeviceFaultRecord();

    List<DeviceFault> queryDeviceFault(DevicePage devicePage);

    int insertDeviceFault(DeviceFault deviceFault);

    int deleteDeviceFault(String ids);

    int updateDeviceFault(DeviceFault deviceFault);
}
