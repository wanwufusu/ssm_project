package com.ssm.service.schedule;

import com.ssm.bean.schedule.Order;
import com.ssm.bean.schedule.PageDetail;

import java.util.List;

public interface OrderService {
    List<Order> queryPageOrder(PageDetail pageDetail);

    int queryAllOrder();

    int insertOrder(Order order);

    int deleteOrders(String[] ids);

    int updateByOrderId(Order updateOrder);

    List<Order> queryOrders();
}
