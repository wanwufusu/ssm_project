package com.ssm.service.schedule;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Task> queryPageTask(PageDetail pageDetail);

    int queryAllTask();

    int insertTask(Task task);

    int deleteTasks(String[] ids);

    int updateByTaskId(Task updateTask);

    List<Task> queryPageTaskByTaskId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByTaskId(Map<String, String> condition);

    List<Task> queryPageTaskByWorkId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByWorkId(Map<String, String> condition);

    List<Task> queryPageTaskByManufactureSn(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByManufactureSn(Map<String, String> condition);
}
