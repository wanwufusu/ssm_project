package com.ssm.service.material.Impl;

import com.ssm.bean.material.MaterialConsume;
import com.ssm.mapper.material.MaterialConsumeMapper;
import com.ssm.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public int queryCount() {
        return materialConsumeMapper.queryCount();
    }

    @Override
    public List selectListByPage(int offset, int rows) {
        return materialConsumeMapper.selectListByPage(offset,rows);
    }

    @Override
    public MaterialConsume selectMaterialConsumeById(String consumeId) {
        return materialConsumeMapper.selectMaterialConsumeById(consumeId);
    }

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
        return materialConsumeMapper.insertMaterialConsume(materialConsume);
    }

    @Override
    public List findWorkList() {
        return materialConsumeMapper.findWorkList();
    }

    @Override
    public int updateMaterialConsumeById(MaterialConsume materialConsume) {
        return materialConsumeMapper.updateMaterialConsumeById(materialConsume);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return materialConsumeMapper.deleteBatch(ids);
    }

    @Override
    public List<MaterialConsume> searchMaterialConsume(int offset, int rows, String searchValue) {
        return materialConsumeMapper.searchMaterialConsume(offset,rows,searchValue);
    }

    @Override
    public int searchMaterialConsumeCount(String searchValue) {
        return materialConsumeMapper.searchMaterialConsumeCount(searchValue);
    }

    @Override
    public int updateNote(String consumeId, String note) {
        return materialConsumeMapper.updateNote(consumeId,note);
    }
}
