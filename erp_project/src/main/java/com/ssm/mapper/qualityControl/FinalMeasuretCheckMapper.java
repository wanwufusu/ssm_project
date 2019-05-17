package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.FinalMeasuretCheck;


import java.util.List;

public interface FinalMeasuretCheckMapper {

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
}