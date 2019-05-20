package com.ssm.service.technology;

import com.ssm.bean.technology.Process;
import com.ssm.mapper.technology.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public List<Process> findAll() {
        List<Process> processes = processMapper.findAll();
        return processes;
    }

    @Override
    public Process findById(String processId) {
        Process data = processMapper.selectByPrimaryKey(processId);
        return data;
    }

    @Override
    public List<Process> findProcess(int rows, int offset) {
        List<Process> processes = processMapper.findByPage(rows,offset);
        return processes;
    }

    @Override
    public boolean addProcess(Process process) {
        Process check = processMapper.selectByPrimaryKey(process.getProcessId());
        if(check == null){
            processMapper.insert(process);
            return true;
        }
        return false;
    }

    @Override
    public boolean editProcess(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProcess(String ids) {
        processMapper.deleteByPrimaryKey(ids);
        return true;
    }

    @Override
    public List<Process> findProcessById(String pid, Integer rows, Integer offset) {
        List<Process> processes = processMapper.findByPid(pid,rows,offset);
        return null;
    }
}
