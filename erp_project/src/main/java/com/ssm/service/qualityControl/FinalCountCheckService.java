package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckService {
    List<FinalCountCheck> findByPage(int rows, int offset);
    int findAllCount();
}
