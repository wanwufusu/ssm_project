package com.ssm.mapper.qualityControl;

import com.ssm.bean.qualityControl.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckMapper {
    List<ProcessCountCheck> findByPage(@Param("rows") int rows, @Param("offset") int offset);
    int findAllCount();

}