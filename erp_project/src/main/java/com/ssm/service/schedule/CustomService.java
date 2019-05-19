package com.ssm.service.schedule;


import com.ssm.bean.schedule.Custom;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;

public interface CustomService {
    List<Custom> queryPageCustom(PageDetail pageDetail);
    int queryAllRecord();
    int queryAllRecordByCustomId(String searchValue);
    int queryAllRecordBycustomName(String searchValue);
    int insertCustom(Custom custom);
    int deleteCustom(String customId);
    int updateByCustomId(Custom custom);
    List<Custom> queryPageCustomByCustomId(PageDetail pageDetail, String searchValue);
    List<Custom> queryPageCustomBycustomName(PageDetail pageDetail, String searchValue);

    Custom queryCustomByCustomId(String customId);
}
