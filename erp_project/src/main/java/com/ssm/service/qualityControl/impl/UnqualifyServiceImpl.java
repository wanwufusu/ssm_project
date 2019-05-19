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
    UnqualifyMapper unqualifyMapper;

    @Override
    public List<UnqualifyApply> findByPage(int rows, int offset) {
        List<UnqualifyApply> byPage = unqualifyMapper.findByPage(rows, offset);
        return byPage;
    }

    @Override
    public int findAllCount() {
        int allCount = unqualifyMapper.findAllCount();
        return allCount;
    }

    @Override
    public int updateNote(String id, String note) {
        int i = unqualifyMapper.updateNote(id, note);
        return i;
    }
}
