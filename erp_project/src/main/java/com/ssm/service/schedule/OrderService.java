package com.ssm.service.schedule;

import com.ssm.bean.schedule.Order;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> queryPageOrder(PageDetail pageDetail);

    int queryAllOrder();

    int insertOrder(Order order);

    int deleteOrders(String[] ids);

    int updateByOrderId(Order updateOrder);

    List<Order> queryOrders();

    List<Order> queryPageOrderByOrderId(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByOrderId(Map<String, String> condition);

    List<Order> queryPageOrderByCustomName(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByCustomName(Map<String, String> condition);

    List<Order> queryPageOrderByProductName(PageDetail pageDetail, Map<String, String> condition);

    int queryAllRecordByProductName(Map<String, String> condition);
}
