package com.ssm.service.schedule.impl;

import com.ssm.bean.schedule.Order;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.mapper.schedule.OrderMapper;
import com.ssm.service.schedule.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/19
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> queryPageOrder(PageDetail pageDetail) {
        return orderMapper.selectByPageInformation(pageDetail);
    }

    @Override
    public int queryAllOrder() {
        return orderMapper.selectAllRecords();
    }

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrders(String[] ids) {
        return orderMapper.deleteOrdersByPrimaryKey(ids);
    }

    @Override
    public int updateByOrderId(Order updateOrder) {
        return orderMapper.updateByPrimaryKeySelective(updateOrder);
    }

    @Override
    public List<Order> queryOrders() {
        return orderMapper.selectAllOrders();
    }

    @Override
    public List<Order> queryPageOrderByOrderId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("orderId", "%" + condition.get("orderId") + "%");
        return orderMapper.selectByPageAndOrderCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByOrderId(Map<String, String> condition) {
        return orderMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Order> queryPageOrderByCustomName(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("customName", "%" + condition.get("customName") + "%");
        return orderMapper.selectByPageAndOrderCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByCustomName(Map<String, String> condition) {
        return orderMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Order> queryPageOrderByProductName(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("productName", "%" + condition.get("productName") + "%");
        return orderMapper.selectByPageAndOrderCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProductName(Map<String, String> condition) {
        return orderMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public Order queryOrderByOrderIdId(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
