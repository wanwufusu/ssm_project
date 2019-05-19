package com.ssm.service.material.Impl;


import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import com.ssm.mapper.material.MaterialMapper;
import com.ssm.service.material.MaterialService;
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
    public int findCount() {
        return materialMapper.findCount();

    }

    @Override
    public int insertMaterial(Material material) {
        return materialMapper.insertMaterial(material);
    }

    @Override
    public Material selectMaterialById(String materialId) {
        return materialMapper.selectMaterialById(materialId);
    }

    @Override
    public List findAllMaterialList() {
        return materialMapper.findAllMaterialList();
    }

    @Override
    public int updateMaterialById(Material material) {
        return materialMapper.updateMaterialById(material);
    }

    @Override
    public int deleteBatch(String[] ids) {

        return materialMapper.deleteBatch(ids);

    }
}
