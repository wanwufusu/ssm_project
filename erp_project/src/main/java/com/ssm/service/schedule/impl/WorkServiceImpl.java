package com.ssm.service.schedule.impl;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;
import com.ssm.mapper.schedule.WorkMapper;
import com.ssm.service.schedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public int insertWork(Work work) {
        return workMapper.insert(work);
    }

    @Override
    public int deleteWorks(String[] ids) {
        return workMapper.deleteWorksByPrimaryKey(ids);
    }

    @Override
    public int updateByWorkId(Work updateWork) {
        return workMapper.updateByPrimaryKeySelective(updateWork);
    }

    @Override
    public List<Work> queryPageWorkByWorkId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("workId", "%" + condition.get("workId") + "%");
        return workMapper.selectByPageAndWorkCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByWorkId(Map<String, String> condition) {
        return workMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Work> queryPageWorkByProductName(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("productName", "%" + condition.get("productName") + "%");
        return workMapper.selectByPageAndWorkCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProductName(Map<String, String> condition) {
        return workMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Work> queryPageWorkByDeviceName(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("deviceName", "%" + condition.get("deviceName") + "%");
        return workMapper.selectByPageAndWorkCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByDeviceName(Map<String, String> condition) {
        return workMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Work> queryPageWorkByProcessId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("processId", "%" + condition.get("processId") + "%");
        return workMapper.selectByPageAndWorkCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProcessId(Map<String, String> condition) {
        return workMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public Work queryWorkById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }
}
