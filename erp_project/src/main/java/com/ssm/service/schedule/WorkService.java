package com.ssm.service.schedule;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;

import java.util.List;
import java.util.Map;

public interface WorkService {
    List<Work> queryPageWork(PageDetail pageDetail);

    int queryAllWork();

    List<Work> queryWorks();

    int insertWork(Work work);

    int deleteWorks(String[] ids);

    int updateByWorkId(Work updateWork);

    List<Work> queryPageWorkByWorkId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByWorkId(Map<String, String> condition);

    List<Work> queryPageWorkByProductName(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByProductName(Map<String, String> condition);

    List<Work> queryPageWorkByDeviceName(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByDeviceName(Map<String, String> condition);

    List<Work> queryPageWorkByProcessId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByProcessId(Map<String, String> condition);

    Work queryWorkById(String workId);
}
