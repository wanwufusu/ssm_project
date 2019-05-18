package com.ssm.mapper.qualityControl;


import com.ssm.bean.qualityControl.UnqualifyApply;



import java.util.List;

public interface UnqualifyApplyMapper {

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
}