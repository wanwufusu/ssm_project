package com.ssm.service.technology;

import com.ssm.bean.technology.PageHelper;
import com.ssm.bean.technology.Technology;
import com.ssm.bean.technology.TechnologyExample;
import com.ssm.mapper.technology.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public boolean addTechnology(Technology technology) {
        Technology check = technologyMapper.selectByPrimaryKey(technology.getTechnologyId());
        if(check == null){
            technologyMapper.insert(technology);
            return true;
        }
        return false;
    }

    @Override
    public boolean editTechnology(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTechnology(String id) {
        technologyMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public List<Technology> findTechnologyById(String id,int rows,int offset) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdEqualTo(id).andDoubleCapacityBetween(offset,offset + rows);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public List<Technology> findTechnologyByName(String name,int rows,int offset) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameEqualTo(name).andDoubleCapacityBetween(offset,offset + rows);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public List<Technology> findTechnology(int rows,int offset) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdBetween(String.valueOf(offset),String.valueOf(offset + rows));
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }
}
