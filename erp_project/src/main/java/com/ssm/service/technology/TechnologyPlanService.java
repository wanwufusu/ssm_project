package com.ssm.service.technology;

import com.ssm.bean.technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {
    boolean addTechnologyPlan(TechnologyPlan technologyPlan);
    boolean editTechnologyPlan(TechnologyPlan technologyPlan);
    boolean deleteTechnologyPlan(String id);
    List<TechnologyPlan> findTechnologyPlanById(String id, int rows, int offset);
    List<TechnologyPlan> findTechnologyPlanByName(String name, int rows, int offset);
    List<TechnologyPlan> findTechnologyPlan(int rows, int offset);
    List<TechnologyPlan> findPlan();
    TechnologyPlan findById(String technologyPlanId);
}
