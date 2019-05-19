package com.ssm.service.schedule;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;

import java.util.List;

public interface WorkService {
    List<Work> queryPageWork(PageDetail pageDetail);

    int queryAllWork();

    List<Work> queryWorks();
}
