package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasureCheckService {

    List<FinalMeasuretCheck> findByPage(int rows, int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);

    List searchList(String target, String word, int offset, int rows);

    int searchAllCount(String target, String word);

    int updateAll(FinalMeasuretCheck record);

    int  insert(FinalMeasuretCheck record);

}
