package com.ssm.service.technology;



import com.ssm.bean.technology.Technology;

import java.util.List;

public interface TechnologyService {
       boolean addTechnology(Technology technology);
       boolean editTechnology(Technology technology);
       boolean deleteTechnology(String id);
       List<Technology> findTechnologyById(String id, int rows, int offset);
       List<Technology> findTechnologyByName(String name, int rows, int offset);
       List<Technology> findTechnology(int rows, int offset);
       List findTechnologyId();

}
