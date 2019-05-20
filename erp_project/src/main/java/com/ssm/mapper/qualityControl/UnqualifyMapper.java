package com.ssm.mapper.qualityControl;

import com.ssm.bean.qualityControl.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyMapper {

    List<UnqualifyApply> findByPage(@Param("rows") int rows,@Param("offset") int offset);

    int findAllCount();

    int updateNote(@Param("id") String id,@Param("note") String note);

    int deleteByIds(@Param("ids") String[] ids);

    List searchList(@Param("target") String target, @Param("word") String word, @Param("offset") int offset, @Param("rows") int rows);

    int searchAllCount(@Param("target") String target, @Param("word") String word);

    int updateAll(@Param("record") UnqualifyApply record);

    int insert(@Param("record") UnqualifyApply record);

//    int deleteByPrimaryKey(String unqualifyApplyId);
//
//    int insert(UnqualifyApply record);
//
//    int insertSelective(UnqualifyApply record);
//
//    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);
//
//    int updateByPrimaryKeySelective(UnqualifyApply record);
//
//    int updateByPrimaryKey(UnqualifyApply record);
}
