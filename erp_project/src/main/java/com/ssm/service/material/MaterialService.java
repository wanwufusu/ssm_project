package com.ssm.service.material;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MaterialService {
    public List findList(int page, int rows);


     int findCount();

    int insertMaterial(Material material);

    Material selectMaterialById(String materialId);

    List findAllMaterialList();

    int updateMaterialById(Material material);

    int deleteBatch(String[] ids);

    List<Material> searchMaterial(int offset, int rows, String searchValue);

    int searchMaterialCount(String searchValue);

    int updateNote(String materialId, String note);
}
