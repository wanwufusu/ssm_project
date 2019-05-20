package com.ssm.service.material.Impl;

import com.ssm.bean.material.MaterialReceive;
import com.ssm.mapper.material.MaterialReceiveMapper;
import com.ssm.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Override
    public List<MaterialReceive> materialReceiveList(int rows, int offset) {
        List<MaterialReceive> materialReceiveList = materialReceiveMapper.materialReceiveList(rows,offset);
        return materialReceiveList;
    }

    @Override
    public int findReceiveCount() {
        return materialReceiveMapper.findReceiveCount();
    }

    @Override
    public int updateMaterialReceiveById(MaterialReceive materialReceive) {
        return materialReceiveMapper.updateMaterialReceiveById(materialReceive);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return materialReceiveMapper.deleteBatch(ids);
    }

    @Override
    public List<MaterialReceive> searchMaterialReceive(int offset, int rows, String searchValue) {
        return materialReceiveMapper.searchMaterialReceive(offset,rows,searchValue);
    }

    @Override
    public int searchMaterialReceiveCount(String searchValue) {
        return materialReceiveMapper.searchMaterialReceiveCount(searchValue);
    }

    @Override
    public MaterialReceive selectMaterialReceiveById(String receiveId) {
        return materialReceiveMapper.selectMaterialReceiveById(receiveId);
    }

    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive) {
        return materialReceiveMapper.insertMaterialReceive(materialReceive);
    }
}
