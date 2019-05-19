package com.ssm.mapper.schedule;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    List<Work> selectByPageInformation(@Param("pageDetail") PageDetail pageDetail);

    int selectAllRecords();

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectAllWorks();
}
