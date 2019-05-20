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
        return null;
    }
}
