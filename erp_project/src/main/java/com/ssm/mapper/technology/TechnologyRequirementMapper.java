package com.ssm.mapper.technology;

import com.ssm.bean.technology.TechnologyRequirement;
import com.ssm.bean.technology.TechnologyRequirementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> findByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<TechnologyRequirement> findById(@Param("id") String id, @Param("rows") Integer rows, @Param("offset") int offset);

    List<TechnologyRequirement> findByName(@Param("name") String name, @Param("rows") Integer rows, @Param("offset") int offset);
}