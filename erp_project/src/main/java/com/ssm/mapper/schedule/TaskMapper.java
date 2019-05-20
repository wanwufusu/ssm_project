package com.ssm.mapper.schedule;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    List<Task> selectByPageInformation(@Param("pageDetail") PageDetail pageDetail);

    int selectAllRecords();

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    int deleteTasksByPrimaryKey(@Param("taskIds") String[] ids);

    List<Task> selectByPageAndTaskCondition(@Param("pageDetail")PageDetail pageDetail,@Param("condition") Map<String, String> condition);

    int selectAllRecordsByCondition(@Param("condition")Map<String, String> condition);
}