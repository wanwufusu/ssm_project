package com.ssm.mapper.device;


import java.util.List;

import com.ssm.bean.device.DeviceCheck;
import com.ssm.bean.device.DeviceCheckExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {
    List<DeviceCheck> queryAllDeviceCheckByPage(@Param("offset") int offset,@Param("rows") int rows);

    int insertDeviceCheck(DeviceCheck deviceCheck);

    //deviceType的接口
    List<DeviceCheck> queryAllDeviceCheck();

    //根据id来查询
    DeviceCheck queryDeviceCheckById(int deviceCheckId);

    int updateDeviceCheck(DeviceCheck deviceCheck);

    int deleteDeviceCheck(@Param("id") String ids);

    //差个数
    int queryAllDeviceCheckRecord();


















    /*long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);*/
}