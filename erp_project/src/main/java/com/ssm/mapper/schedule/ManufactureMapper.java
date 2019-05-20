package com.ssm.mapper.schedule;

import com.ssm.bean.schedule.Manufacture;
import com.ssm.bean.schedule.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> selectByPageInformation(@Param("pageDetail")PageDetail pageDetail);

    int selectAllRecords();

    int deleteManufacturesByPrimaryKey(@Param("manufactureSns") String[] ids);

    List<Manufacture> selectByPageAndManufactureCondition(@Param("pageDetail")PageDetail pageDetail, @Param("condition")Map<String, String> condition);

    int selectAllRecordsByCondition(@Param("condition")Map<String, String> condition);
}