package com.ssm.service.device;

import com.ssm.bean.device.Device;
import com.ssm.bean.device.DevicePage;

import java.util.List;

public interface DeviceService {
    List<Device> queryDevice(DevicePage devicePage);
    int findCount();

    //接口
    List<Device> getDataOfDevice();


    int insertDevice(Device device);

    int deleteDevice(String ids);

    //按id查询
    Device queryDeviceByProductId(String deviceId);

    int updataDevice(Device device);
}
