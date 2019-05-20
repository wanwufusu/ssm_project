package com.ssm.service.qualityControl.impl;

import com.ssm.bean.qualityControl.UnqualifyApply;
import com.ssm.mapper.qualityControl.UnqualifyMapper;
import com.ssm.service.qualityControl.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {
    @Autowired
    UnqualifyMapper mapper;

    @Override
    public List<UnqualifyApply> findByPage(int rows, int offset) {
        List<UnqualifyApply> byPage = mapper.findByPage(rows, offset);
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

    @Override
    public int updateAll(UnqualifyApply record) {
        return mapper.updateAll(record);
    }
    @Override
    public int insert(UnqualifyApply record) {
        return mapper.insert(record);
    }


}
