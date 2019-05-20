package com.ssm.service.qualityControl.impl;

import com.ssm.bean.qualityControl.FinalCountCheck;
import com.ssm.mapper.qualityControl.FinalCountCheckMapper;
import com.ssm.service.qualityControl.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public List<FinalCountCheck> findByPage(int rows, int offset) {
        List<FinalCountCheck> byPage = finalCountCheckMapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        return finalCountCheckMapper.findAllCount();
    }

    @Override
    public int updateNote(String id, String note) {
        int i = finalCountCheckMapper.updateNote(id, note);
        return i;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return finalCountCheckMapper.deleteByIds(ids);
    }
}
