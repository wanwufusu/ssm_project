package com.ssm.service.qualityControl.impl;

import com.ssm.bean.qualityControl.ProcessCountCheck;
import com.ssm.mapper.qualityControl.ProcessCountCheckMapper;
import com.ssm.service.qualityControl.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public List<ProcessCountCheck> findByPage(int rows, int offset) {
        List<ProcessCountCheck> byPage = processCountCheckMapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        int allCount = processCountCheckMapper.findAllCount();
        return allCount;
    }
    @Override
    public int updateNote(String id, String note) {
        int i = processCountCheckMapper.updateNote(id, note);
        return i;
    }
}