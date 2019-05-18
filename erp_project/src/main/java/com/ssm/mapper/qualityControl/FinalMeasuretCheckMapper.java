package com.ssm.mapper.qualityControl;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface FinalMeasuretCheckMapper {
    List<FinalMeasuretCheck> findByPage(@Param("rows") int rows,@Param("offset") int offset);
}
