package com.ssm.service.schedule.impl;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;
import com.ssm.mapper.schedule.WorkMapper;
import com.ssm.service.schedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/19
 * @since 1.0.0*/
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> queryPageWork(PageDetail pageDetail) {
        return workMapper.selectByPageInformation(pageDetail);
    }

    @Override
    public int queryAllWork() {
        return workMapper.selectAllRecords();
    }

    @Override
    public List<Work> queryWorks() {
        return workMapper.selectAllWorks();
    }
}
