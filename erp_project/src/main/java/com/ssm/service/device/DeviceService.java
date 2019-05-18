package com.ssm.service.device;

import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceType;


import java.util.List;

public interface DeviceService {
    List<DeviceType> queryDeviceType(DevicePage devicePage);
}
