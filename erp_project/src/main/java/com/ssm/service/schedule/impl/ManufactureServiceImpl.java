package com.ssm.service.schedule.impl;

import com.ssm.bean.schedule.Manufacture;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.mapper.schedule.ManufactureMapper;
import com.ssm.service.schedule.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/20
 * @since 1.0.0
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<Manufacture> queryPageManufacture(PageDetail pageDetail) {
        return manufactureMapper.selectByPageInformation(pageDetail);
    }

    @Override
    public int queryAllManufacture() {
        return manufactureMapper.selectAllRecords();
    }

    @Override
    public int insertManufacture(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture);
    }

    @Override
    public int deleteManufactures(String[] ids) {
        return manufactureMapper.deleteManufacturesByPrimaryKey(ids);
    }

    @Override
    public int updateByManufactureId(Manufacture updateManufacture) {
        return manufactureMapper.updateByPrimaryKeySelective(updateManufacture);
    }
}
