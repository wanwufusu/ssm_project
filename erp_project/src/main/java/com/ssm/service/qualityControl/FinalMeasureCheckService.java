package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasureCheckService {
    List<FinalMeasuretCheck> findByPage(int rows, int offset);
}