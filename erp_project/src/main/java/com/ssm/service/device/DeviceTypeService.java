package com.ssm.service.device;





import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    List<DeviceType> queryDeviceType(DevicePage devicePage);

    int queryAllDeviceTypeRecord();

    int insertDeviceType(DeviceType deviceType);
    //DeviceType的接口
    List<DeviceType> getDataOfDeviceType();
    //更新
    int updateDeviceType(DeviceType deviceType);

    int deleteDeviceType(String ids);

    DeviceType getDeviceTypeById(String id);
}
