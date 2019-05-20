package com.ssm.mapper.qualityControl;

import com.ssm.bean.qualityControl.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyMapper {

    List<UnqualifyApply> findByPage(@Param("rows") int rows,@Param("offset") int offset);

    int findAllCount();

    int updateNote(@Param("id") String id,@Param("note") String note);

    int deleteByIds(@Param("ids") String[] ids);

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
