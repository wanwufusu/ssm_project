package com.ssm.mapper.device;


import java.util.List;

import com.ssm.bean.device.DeviceFault;
import com.ssm.bean.device.DeviceFaultExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultMapper {


    List<DeviceFault> queryAllDeviceFaultByPage(@Param("offset") int offset,@Param("rows") int rows);

    int insertDeviceFault(DeviceFault deviceFault);

    //deviceType的接口
    List<DeviceFault> queryAllDeviceFault();

    //根据id来查询
    DeviceFault queryDeviceFaultById(int deviceFaultId);

    int updateDeviceFault(DeviceFault deviceFault);

    int deleteDeviceFault(@Param("id") String ids);

    int queryAllDeviceFaultRecord();






    /*以下是自动生成的-----------------------*/
    /*long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);*/
}