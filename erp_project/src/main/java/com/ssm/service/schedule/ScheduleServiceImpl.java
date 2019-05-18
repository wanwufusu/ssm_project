package com.ssm.service.schedule;

import com.ssm.bean.schedule.Custom;
import com.ssm.bean.schedule.CustomExample;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.mapper.schedule.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> queryPageCustom(PageDetail pageDetail) {
/*
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria().andCustomIdIsNotNull();
        criteria.andCustomIdIsNotNull();
        List<Custom> customs = customMapper.selectByExample(customExample);*/

        List<Custom> customs = customMapper.selectByPageInformation(pageDetail);

        return customs;
    }

    @Override
    public int queryAllRecord() {
        return customMapper.selectAllRecords();
    }

    @Override
    public int insertCustom(Custom custom) {
        return customMapper.insert(custom);
    }
}
