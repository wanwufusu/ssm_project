package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {

    List<FinalCountCheck> findByPage(@Param("rows") int rows, @Param("offset") int offset);

    int findAllCount();

    int updateNote(@Param("id") String id,@Param("note") String note);

    int deleteByIds(@Param("ids") String[] ids);

    List searchList(@Param("target") String target, @Param("word") String word, @Param("offset") int offset, @Param("rows") int rows);

    int searchAllCount(@Param("target") String target, @Param("word") String word);

    int updateAll(@Param("record") FinalCountCheck record);

    int insert(@Param("record") FinalCountCheck record);

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
