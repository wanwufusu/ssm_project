package com.ssm.service.qualityControl.impl;

import com.ssm.bean.qualityControl.ProcessMeasureCheck;
import com.ssm.mapper.qualityControl.ProcessMeasureCheckMapper;
import com.ssm.service.qualityControl.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public List<ProcessMeasureCheck> findByPage(int rows, int offset) {
        List<ProcessMeasureCheck> byPage = processMeasureCheckMapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        int allCount = processMeasureCheckMapper.findAllCount();
        return allCount;
    }
}