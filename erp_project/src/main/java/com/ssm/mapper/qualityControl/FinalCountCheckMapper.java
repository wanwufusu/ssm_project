package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckMapper {

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}