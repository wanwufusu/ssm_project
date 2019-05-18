package com.ssm.service.material;


import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import com.ssm.mapper.material.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> findList(int rows, int offset) {
        List<Material> materialList = materialMapper.findList(rows,offset);
        return materialList;
    }

    @Override
    public List<MaterialReceive> materialReceiveList(int rows, int offset) {
        List<MaterialReceive> materialReceiveList = materialMapper.materialReceiveList(rows,offset);
        return materialReceiveList;
    }
}
