package com.ssm.mapper.device;


import java.util.List;

import com.ssm.bean.device.Device;
import com.ssm.bean.device.DeviceExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {

    List<Device> queryAllDeviceByPage(@Param("offset") int offset, @Param("rows") int rows);

    int findCount();
    //接口
    List<Device> queryAllDevice();
    //根据id来查询

    Device queryDeviceById(@Param("device_id") String deviceId);


    int updateDevice(@Param("device") Device device);

    int deleteDevice(@Param("id") String ids);

    int insertDevice(Device device);

    //逆向工程生成

    /*long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);*/


}