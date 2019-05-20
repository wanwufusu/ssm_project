package com.ssm.service.qualityControl.impl;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;
import com.ssm.mapper.qualityControl.FinalMeasuretCheckMapper;
import com.ssm.service.qualityControl.FinalMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService {

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public List<FinalMeasuretCheck> findByPage(int rows, int offset) {
        List<FinalMeasuretCheck> item = finalMeasuretCheckMapper.findByPage(rows, offset);
        return item;
    }

    @Override
    public int findAllCount() {
        return finalMeasuretCheckMapper.findAllCount();
    }

    @Override
    public int updateNote(String id, String note) {
        int i = finalMeasuretCheckMapper.updateNote(id, note);
        return i;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return finalMeasuretCheckMapper.deleteByIds(ids);
    }
}
