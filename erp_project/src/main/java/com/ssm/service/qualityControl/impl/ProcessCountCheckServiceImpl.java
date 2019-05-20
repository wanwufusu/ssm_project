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
    ProcessCountCheckMapper mapper;

    @Override
    public List<ProcessCountCheck> findByPage(int rows, int offset) {
        List<ProcessCountCheck> byPage = mapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        int allCount = mapper.findAllCount();
        return allCount;
    }
    @Override
    public int updateNote(String id, String note) {
        int i = mapper.updateNote(id, note);
        return i;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return mapper.deleteByIds(ids);
    }


}