package com.ssm.mapper.device;


import java.util.List;

import com.ssm.bean.device.DevicePage;
import com.ssm.bean.device.DeviceType;
import com.ssm.bean.device.DeviceTypeExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceTypeMapper {
    long countByExample(DeviceTypeExample example);

    List<DeviceType> queryAllDeviceTypeByPage(@Param("offset") int offset,@Param("rows") int rows);

    int insertDeviceType(@Param("deviceType") DeviceType deviceType);

    //deviceType的接口
    List<DeviceType> queryAllDeviceType();

    //根据id来查询
    DeviceType queryDeviceTypeById(@Param("deviceType_id") String deviceTypeId);

    int updateDeviceType(@Param("deviceType")DeviceType deviceType);

    int deleteDeviceType(@Param("id") String ids);

    DeviceType getDeviceTypeById(String id);


/*    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);*/
}