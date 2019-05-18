package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.ProcessCountCheck;

import java.util.List;

public interface ProcessCountCheckService {
    List<ProcessCountCheck> findByPage(int rows, int offset);
    int findAllCount();
}