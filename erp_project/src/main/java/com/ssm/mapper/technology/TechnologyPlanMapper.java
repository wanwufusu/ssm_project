package com.ssm.mapper.technology;

import com.ssm.bean.technology.TechnologyPlan;
import com.ssm.bean.technology.TechnologyPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);
    List<TechnologyPlan> findByPage(@Param("rows") int rows,@Param("offset") int offset);
    List<TechnologyPlan> findById(@Param("id") String id,@Param("rows") int rows,@Param("offset") int offset);
    List<TechnologyPlan> findByName(@Param("name") String name,@Param("rows") int rows,@Param("offset") int offset);
}