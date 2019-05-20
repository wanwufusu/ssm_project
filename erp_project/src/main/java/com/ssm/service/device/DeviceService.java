package com.ssm.service.device;

import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;

import java.util.List;

public interface DeviceService {
    List<Device> queryDevice(DevicePage devicePage);
    int findCount();
    /*int insertDeviceType(Device device);
    //Device的接口
    List<Device> getDataOfDevice();*/


}
