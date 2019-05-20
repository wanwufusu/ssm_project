package com.ssm.service.schedule;

import com.ssm.bean.schedule.Manufacture;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> queryPageManufacture(PageDetail pageDetail);

    int queryAllManufacture();

    int insertManufacture(Manufacture manufacture);

    int deleteManufactures(String[] ids);

    int updateByManufactureId(Manufacture updateManufacture);
}
