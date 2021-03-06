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
    FinalCountCheckMapper mapper;

    @Override
    public List<FinalCountCheck> findByPage(int rows, int offset) {
        List<FinalCountCheck> byPage = mapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        return mapper.findAllCount();
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

    @Override
    public int updateAll(FinalCountCheck record) {
        return mapper.updateAll(record);
    }
    @Override
    public int insert(FinalCountCheck record) {
        return mapper.insert(record);
    }
}
