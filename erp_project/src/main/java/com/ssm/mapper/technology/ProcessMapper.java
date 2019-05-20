package com.ssm.mapper.technology;

import com.ssm.bean.technology.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> findByPage(@Param("rows") int rows,@Param("offset") int offset);

    List<Process> findAll();

    List<Process> findByPid(@Param("pid") String pid, @Param("rows") Integer rows, @Param("offset") Integer offset);

    List<Process> findByTid(@Param("tid") String tid, @Param("rows") int rows, @Param("offset") int offset);
}