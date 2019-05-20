package com.ssm.service.qualityControl;

import com.ssm.bean.qualityControl.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasureCheckService {

    List<FinalMeasuretCheck> findByPage(int rows, int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);



}
