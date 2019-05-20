package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {

    List<ProcessMeasureCheck> findByPage(int rows, int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);

    List searchList(String target, String word, int offset, int rows);

    int searchAllCount(String target, String word);

    int updateAll(ProcessMeasureCheck record);

    int  insert(ProcessMeasureCheck record);
}