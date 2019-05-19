package com.ssm.mapper.material;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    public List<Material> findList(@Param("rows")int rows, @Param("offset") int offset);




    public int findCount();

    int insertMaterial(Material material);

    Material selectMaterialById(@Param("material_id") String materialId);

    List findAllMaterialList();
}
