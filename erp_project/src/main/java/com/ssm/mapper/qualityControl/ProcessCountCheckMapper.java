package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.ProcessCountCheck;


import java.util.List;

public interface ProcessCountCheckMapper {

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
}