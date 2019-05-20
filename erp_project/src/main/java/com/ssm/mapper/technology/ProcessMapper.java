package com.ssm.mapper.technology;

import com.ssm.bean.technology.Process;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> findByPage(int rows, int offset);

    List<Process> findAll();
}