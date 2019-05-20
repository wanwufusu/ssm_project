package com.ssm.service.material;

import com.ssm.bean.material.MaterialReceive;

import java.util.List;

public interface MaterialReceiveService {
    MaterialReceive selectMaterialReceiveById(String receiveId);

    int insertMaterialReceive(MaterialReceive materialReceive);
    List<MaterialReceive> materialReceiveList(int page, int offset);

    int findReceiveCount();

    int updateMaterialReceiveById(MaterialReceive materialReceive);

    int deleteBatch(String[] ids);

    List<MaterialReceive> searchMaterialReceive(int offset, int rows, String searchValue);

    int searchMaterialReceiveCount(String searchValue);

    int updateNote(String materialId, String note);
}
