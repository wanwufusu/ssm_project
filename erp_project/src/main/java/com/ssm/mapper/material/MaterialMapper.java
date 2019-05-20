package com.ssm.mapper.material;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {

     public int deleteBatch(@Param("ids") String[] ids);



    public List<Material> findList(@Param("rows")int rows, @Param("offset") int offset);




    public int findCount();

    int insertMaterial(Material material);

    Material selectMaterialById(@Param("material_id") String materialId);

    List findAllMaterialList();

    int updateMaterialById(Material material);

    List<Material> searchMaterial(@Param("offset") int offset, @Param("rows") int rows, @Param("searchValue") String searchValue);

    int searchMaterialCount(@Param("searchValue") String searchValue);

    int updateNote(@Param("materialId") String materialId, @Param("note") String note);
}
