package com.ssm.mapper;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;


import java.util.List;

public interface FinalMeasuretCheckMapper {
    List<FinalMeasuretCheck> findByPage(int rows,int offset);
}
