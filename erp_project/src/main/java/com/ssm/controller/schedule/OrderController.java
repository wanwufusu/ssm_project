package com.ssm.controller.schedule;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.schedule.Order;
import com.ssm.bean.schedule.PageDetail;
import com.ssm.service.schedule.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("find")
    public String orderList(Model model){
        return "order_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO orders(Model model, PageDetail pageDetail){

        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Order> orders = orderService.queryPageOrder(pageDetail);
        ResponseVO<Order> responseVO = new ResponseVO<>();

        responseVO.setRows(orders);
        responseVO.setTotal(orderService.queryAllOrder());
        return responseVO;
    }

    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public ResponseVO ordersQueryById(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("orderId", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Order> orders = orderService.queryPageOrderByOrderId(pageDetail, condition);
        ResponseVO<Order> responseVO = new ResponseVO<>();
        responseVO.setRows(orders);
        responseVO.setTotal(orderService.queryAllRecordByOrderId(condition));
        return responseVO;
    }
    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public ResponseVO ordersQueryByCustomName(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("customName", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Order> orders = orderService.queryPageOrderByCustomName(pageDetail, condition);
        ResponseVO<Order> responseVO = new ResponseVO<>();
        responseVO.setRows(orders);
        responseVO.setTotal(orderService.queryAllRecordByCustomName(condition));
        return responseVO;
    }
    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public ResponseVO ordersQueryByProductName(Model model, PageDetail pageDetail, String searchValue){
        Map<String, String> condition =  new HashMap<String, String>(){{put("productName", searchValue);}};
        pageDetail.setOffset((pageDetail.getPage()-1)*pageDetail.getRows());
        List<Order> orders = orderService.queryPageOrderByProductName(pageDetail, condition);
        ResponseVO<Order> responseVO = new ResponseVO<>();
        responseVO.setRows(orders);
        responseVO.setTotal(orderService.queryAllRecordByProductName(condition));
        return responseVO;
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public Order addJudge(){
        return new Order();
    }
    @RequestMapping("add")
    public String orderAdd(){
        return "order_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage orderInsert(Order order){
        int i = orderService.insertOrder(order);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "insert fail");
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Order deleteJudge(){
        return new Order();
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseMessage deleteOrders(String[] ids){
        int i = orderService.deleteOrders(ids);
        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "FAIL", "delete fail");
        }
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Order editJudge(){
        return new Order();
    }

    @RequestMapping("edit")
    public String edit(){
        return "order_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage updateAll(Order updateOrder){

        int i = orderService.updateByOrderId(updateOrder);

        if (i > 0) {
            return new ResponseMessage(200, "OK", null);
        } else {
            return new ResponseMessage(404, "fail", "update fail");
        }
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Order> queryAllOrders(){
        return orderService.queryOrders();
    }
}
