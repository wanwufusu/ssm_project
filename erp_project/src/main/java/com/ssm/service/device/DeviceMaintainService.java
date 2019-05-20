package com.ssm.service.device;

import com.ssm.bean.device.DeviceMaintain;
import com.ssm.bean.device.DevicePage;

import java.util.List;


public interface DeviceMaintainService {
    List<DeviceMaintain> getDataOfDeviceMaintain();

    int queryAllDeviceMaintainRecord();

    List<DeviceMaintain> queryDeviceMaintain(DevicePage devicePage);

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(String ids);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);
}
