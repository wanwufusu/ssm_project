package com.ssm.mapper;

import com.ssm.bean.Material;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    public List<Material> findList(@Param("rows")int rows,@Param("offset") int offset);
    public int findCount();
}
