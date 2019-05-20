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
    ProcessMeasureCheckMapper mapper;

    @Override
    public List<ProcessMeasureCheck> findByPage(int rows, int offset) {
        List<ProcessMeasureCheck> byPage = mapper.findByPage(rows, offset);
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

    @Override
    public List searchList(String target, String word, int offset, int rows) {
        List list = mapper.searchList(target, word, offset, rows);
        return list;
    }

    @Override
    public int searchAllCount(String target, String word) {
        int i = mapper.searchAllCount(target, word);
        return i;
    }
}