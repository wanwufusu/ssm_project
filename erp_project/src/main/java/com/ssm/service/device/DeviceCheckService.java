package com.ssm.service.device;

import com.ssm.bean.device.DeviceCheck;
import com.ssm.bean.device.DevicePage;

import java.util.List;

public interface DeviceCheckService {
    List<DeviceCheck> getDataOfDeviceCheck();

    int queryAllDeviceCheckRecord();

    List<DeviceCheck> queryDeviceCheck(DevicePage devicePage);

    int insertDeviceCheck(DeviceCheck deviceCheck);

    int deleteDeviceCheck(String ids);

    int updateDeviceCheck(DeviceCheck deviceCheck);
}
