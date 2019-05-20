package com.ssm.mapper.schedule;

import com.ssm.bean.schedule.Custom;
import com.ssm.bean.schedule.CustomExample;
import com.ssm.bean.schedule.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    List<Custom> selectByPageInformation(@Param("pageDetail")PageDetail pageDetail);

    List<Custom> selectByPageAndCustomId(@Param("pageDetail")PageDetail pageDetail, @Param("customId")String customId);

    List<Custom> selectByPageAndCustomName(@Param("pageDetail")PageDetail pageDetail, @Param("customName")String customName);

    int selectAllRecords();

    int selectAllRecordsByCustomId(@Param("customId")String customId);

    int selectAllRecordsByCustomName(@Param("customName")String customName);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    int deleteCustomsByPrimaryKey(@Param("customIds") String[] customId);

    List<Custom> selectCustoms();
}