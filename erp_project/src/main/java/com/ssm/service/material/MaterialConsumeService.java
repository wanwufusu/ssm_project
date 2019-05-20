package com.ssm.service.material;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialConsume;

import java.util.List;

public interface MaterialConsumeService {
    int queryCount();

    List selectListByPage(int offset,int rows);

    MaterialConsume selectMaterialConsumeById(String consumeId);

    int insertMaterialConsume(MaterialConsume materialConsume);

    List findWorkList();

    int updateMaterialConsumeById(MaterialConsume materialConsume);

    int deleteBatch(String[] ids);

    List<MaterialConsume> searchMaterialConsume(int offset, int rows, String searchValue);

    int searchMaterialConsumeCount(String searchValue);

    int updateNote(String consumeId, String note);
}
