package com.ssm.mapper.technology;

import com.ssm.bean.technology.Technology;
import com.ssm.bean.technology.TechnologyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
    List<Technology> findByPage(@Param("rows") int rows,@Param("offset") int offset);
    List<Technology> findById(@Param("id") String id,@Param("rows") int rows,@Param("offset") int offset);
    List<Technology> findByName(@Param("name") String name,@Param("rows") int rows,@Param("offset") int offset);
    List findTechnologyId();
}