package com.ssm.service.Impl;

import com.ssm.bean.Material;
import com.ssm.mapper.MaterialMapper;
import com.ssm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List findList(int rows,int offset) {
        List<Material> materialList = materialMapper.findList(rows,offset);
        return materialList;
    }
}
