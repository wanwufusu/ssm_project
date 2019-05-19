package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {

    List<FinalCountCheck> findByPage(@Param("rows") int rows, @Param("offset") int offset);

    int findAllCount();

    int updateNote(@Param("id") String id,@Param("note") String note);

    int deleteByIds(@Param("ids") String[] ids);


//    int deleteByPrimaryKey(String fCountCheckId);
//
//    int insert(FinalCountCheck record);
//
//    int insertSelective(FinalCountCheck record);
//
//    FinalCountCheck selectByPrimaryKey(String fCountCheckId);
//
//    int updateByPrimaryKeySelective(FinalCountCheck record);
//
//    int updateByPrimaryKey(FinalCountCheck record);

}
