package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> findByPage(int rows, int offset);
    int findAllCount();
}