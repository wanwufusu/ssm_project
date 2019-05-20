package com.ssm.mapper.schedule;

import com.ssm.bean.schedule.Order;
import com.ssm.bean.schedule.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByPageInformation(@Param("pageDetail") PageDetail pageDetail);

    int selectAllRecords();

    int deleteOrdersByPrimaryKey(@Param("orderIds") String[] ids);

    List<Order> selectAllOrders();

    List<Order> selectByPageAndOrderCondition(@Param("pageDetail")PageDetail pageDetail, @Param("condition")Map<String, String> condition);

    int selectAllRecordsByCondition(@Param("condition") Map<String, String> condition);
}