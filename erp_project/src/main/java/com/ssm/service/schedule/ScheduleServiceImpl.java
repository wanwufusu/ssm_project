package com.ssm.service.schedule;

import com.ssm.bean.Custom;
import com.ssm.bean.CustomExample;
import com.ssm.mapper.CustomMapper;
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
    public List<Custom> queryPageCustom() {

        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria().andCustomIdIsNotNull();
        criteria.andCustomIdIsNotNull();
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }
}
