package com.ssm.mapper.material;

import com.ssm.bean.material.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialReceiveMapper {
    MaterialReceive selectMaterialReceiveById(@Param("receiveId") String receiveId);

    int insertMaterialReceive( MaterialReceive materialReceive);
    public List<MaterialReceive> materialReceiveList(@Param("rows") int rows, @Param("offset") int offset);

    public int findReceiveCount();

    int updateMaterialReceiveById(MaterialReceive materialReceive);

    int deleteBatch(@Param("ids") String[] ids);

    List<MaterialReceive> searchMaterialReceive(@Param("offset") int offset, @Param("rows") int rows,@Param("searchValue") String searchValue);

    int searchMaterialReceiveCount(@Param("searchValue")String searchValue);
}
