package com.ssm.mapper.material;

import com.ssm.bean.material.MaterialConsume;

import com.ssm.bean.schedule.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialConsumeMapper {
    int queryCount();

    List selectListByPage(@Param("offset") int offset, @Param("rows") int rows);
    Work selectWorkById(@Param("workId") int workId);

    MaterialConsume selectMaterialConsumeById(@Param("consumeId") String consumeId);

    int insertMaterialConsume(MaterialConsume materialConsume);

    List findWorkList();

    int updateMaterialConsumeById(MaterialConsume materialConsume);

    int deleteBatch(@Param("ids") String[] ids);

    List<MaterialConsume> searchMaterialConsume(@Param("offset") int offset,@Param("rows") int rows, @Param("searchValue") String searchValue);

    int searchMaterialConsumeCount(@Param("searchValue") String searchValue);

    int updateNote(@Param("consumeId") String consumeId, @Param("note") String note);
}
