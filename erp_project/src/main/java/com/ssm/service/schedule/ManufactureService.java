package com.ssm.service.schedule;

import com.ssm.bean.schedule.Manufacture;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;
import java.util.Map;

public interface ManufactureService {
    List<Manufacture> queryPageManufacture(PageDetail pageDetail);

    int queryAllManufacture();

    int insertManufacture(Manufacture manufacture);

    int deleteManufactures(String[] ids);

    int updateByManufactureId(Manufacture updateManufacture);

    List<Manufacture> queryPageManufactureByManufactureSn(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByManufactureSn(Map<String, String> condition);

    List<Manufacture> queryPageManufactureByOrderId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByOrderId(Map<String, String> condition);

    List<Manufacture> queryPageManufactureByTechnologyName(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByTechnologyName(Map<String, String> condition);
}
