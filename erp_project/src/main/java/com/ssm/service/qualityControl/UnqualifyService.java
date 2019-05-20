package com.ssm.service.qualityControl;


import com.ssm.bean.qualityControl.UnqualifyApply;

import java.util.List;


public interface UnqualifyService {

    List<UnqualifyApply> findByPage(int rows,int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);

    List<UnqualifyApply> searchList(String target, String word, int offset, int rows);

    int searchAllCount(String target, String word);

}
