package com.ssm.service.schedule;


import com.ssm.bean.schedule.Custom;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;

public interface ScheduleService {
    List<Custom> queryPageCustom(PageDetail pageDetail);
    int queryAllRecord();
    int insertCustom(Custom custom);
}
