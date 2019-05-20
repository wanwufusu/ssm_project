package com.ssm.service.technology;

import com.ssm.bean.technology.Technology;
import com.ssm.bean.technology.TechnologyExample;
import com.ssm.bean.technology.TechnologyPlan;
import com.ssm.bean.technology.TechnologyPlanExample;
import com.ssm.mapper.technology.TechnologyMapper;
import com.ssm.mapper.technology.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public boolean addTechnologyPlan(TechnologyPlan technologyPlan) {
        TechnologyPlan check = technologyPlanMapper.selectByPrimaryKey(technologyPlan.getTechnologyPlanId());
        if(check == null){
            technologyPlanMapper.insert(technologyPlan);
            return true;
        }
        return false;
    }

    @Override
    public boolean editTechnologyPlan(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTechnologyPlan(String id) {
        technologyPlanMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public List<TechnologyPlan> findTechnologyPlanById(String id, int rows, int offset) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findById(id,rows,offset);
        return technologyPlans;
    }

    @Override
    public List<TechnologyPlan> findTechnologyPlanByName(String name, int rows, int offset) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findByName(name,rows,offset);
        return technologyPlans;
    }

    @Override
    public List<TechnologyPlan> findTechnologyPlan(int rows, int offset) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findByPage(rows,offset);
        return technologyPlans;
    }

    @Override
    public TechnologyPlan getTechnology(TechnologyPlan technologyPlan) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyPlan.getTechnologyId());
        technologyPlan.setTechnologyName(technology.getTechnologyName());
        return technologyPlan;
    }

    @Override
    public List<TechnologyPlan> findPlan() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findPlan();
        return technologyPlans;
    }

    @Override
    public TechnologyPlan findById(String technologyPlanId) {
        TechnologyPlan data = technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
        return data;
    }
}
