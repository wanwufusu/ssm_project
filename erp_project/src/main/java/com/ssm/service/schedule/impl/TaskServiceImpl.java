package com.ssm.service.schedule.impl;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Task;
import com.ssm.mapper.schedule.TaskMapper;
import com.ssm.service.schedule.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/20
 * @since 1.0.0
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> queryPageTask(PageDetail pageDetail) {
        return taskMapper.selectByPageInformation(pageDetail);
    }

    @Override
    public int queryAllTask() {
        return taskMapper.selectAllRecords();
    }

    @Override
    public int insertTask(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int deleteTasks(String[] ids) {
        return taskMapper.deleteTasksByPrimaryKey(ids);
    }

    @Override
    public int updateByTaskId(Task updateTask) {
        return taskMapper.updateByPrimaryKeySelective(updateTask);
    }

    @Override
    public List<Task> queryPageTaskByTaskId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("taskId", "%" + condition.get("taskId") + "%");
        return taskMapper.selectByPageAndTaskCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByTaskId(Map<String, String> condition) {
        return taskMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Task> queryPageTaskByWorkId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("workId", "%" + condition.get("workId") + "%");
        return taskMapper.selectByPageAndTaskCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByWorkId(Map<String, String> condition) {
        return taskMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Task> queryPageTaskByManufactureSn(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("manufactureSn", "%" + condition.get("manufactureSn") + "%");
        return taskMapper.selectByPageAndTaskCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByManufactureSn(Map<String, String> condition) {
        return taskMapper.selectAllRecordsByCondition(condition);
    }
}
