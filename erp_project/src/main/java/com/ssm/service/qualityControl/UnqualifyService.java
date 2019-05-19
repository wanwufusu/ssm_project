package com.ssm.service.qualityControl;


import com.ssm.bean.qualityControl.UnqualifyApply;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UnqualifyService {

    List<UnqualifyApply> findByPage(int rows,int offset);

    int findAllCount();

    int updateNote(String id,String note);

    int deleteByIds(String[] ids);
}
