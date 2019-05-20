package com.ssm.service.technology;

import com.ssm.bean.technology.TechnologyRequirement;
import com.ssm.mapper.technology.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Override
    public List<TechnologyRequirement> findTechnologyRequirement(int rows, int offset) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findByPage(rows,offset);
        return technologyRequirements;
    }


    @Override
    public boolean addTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        TechnologyRequirement check = technologyRequirementMapper.selectByPrimaryKey(technologyRequirement.getTechnologyRequirementId());
        if(check == null){
            technologyRequirementMapper.insert(technologyRequirement);
            return true;
        }
        return false;

    }
    @Override
    public boolean editTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTechnologyRequirement(String ids) {
        technologyRequirementMapper.deleteByPrimaryKey(ids);
        return true;
    }

    @Override
    public List<TechnologyRequirement> findTechnologyRequirementById(String id, Integer rows, int offset) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findById(id,rows,offset);
        return technologyRequirements;
    }

    @Override
    public List<TechnologyRequirement> findTechnologyRequirementByName(String name, Integer rows, int offset) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findByName(name,rows,offset);
        return technologyRequirements;
    }
}
