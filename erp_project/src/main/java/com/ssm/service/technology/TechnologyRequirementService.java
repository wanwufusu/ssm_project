package com.ssm.service.technology;

import com.ssm.bean.technology.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {
    List<TechnologyRequirement> findTechnologyRequirement(int rows, int offset);

    boolean addTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean editTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean deleteTechnologyRequirement(String ids);

    List<TechnologyRequirement> findTechnologyRequirementById(String id, Integer rows, int offset);

    List<TechnologyRequirement> findTechnologyRequirementByName(String name, Integer rows, int offset);
}
