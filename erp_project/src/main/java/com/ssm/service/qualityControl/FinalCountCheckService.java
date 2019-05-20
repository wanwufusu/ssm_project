package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.FinalCountCheck;
import com.ssm.bean.qualityControl.UnqualifyApply;

import java.util.List;

public interface FinalCountCheckService {

    List<FinalCountCheck> findByPage(int rows, int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);

    List searchList(String target, String word, int offset, int rows);

    int searchAllCount(String target, String word);

    int updateAll(FinalCountCheck record);

    int  insert(FinalCountCheck record);
}
