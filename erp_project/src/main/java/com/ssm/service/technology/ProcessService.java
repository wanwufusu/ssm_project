package com.ssm.service.technology;

import com.ssm.bean.technology.Process;

import java.util.List;

public interface ProcessService {
    List<Process> findAll();

    List<Process> findProcess(int rows, int offset);

    boolean addProcess(Process process);

    boolean editProcess(Process process);

    boolean deleteProcess(String ids);

    List<Process> findProcessById(String pid, int rows, int offset);

    Process findById(String processId);

    List<Process> findProcessByTid(String tid, int rows, int offset);
}
