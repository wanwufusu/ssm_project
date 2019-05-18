package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.ProcessMeasureCheck;


import java.util.List;

public interface ProcessMeasureCheckMapper {


    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);


    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
}