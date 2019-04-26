package com.ccb.springboot.order.service;

import com.ccb.springboot.order.pojo.Item;
import com.ccb.springboot.order.pojo.Order;
import com.ccb.springboot.order.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private static final Map<String, Order> MAP = new HashMap<String, Order>();

    @Autowired
    private ItemService itemService;

    static {
        //构造测试数据
        Order order = new Order();
        order.setOrderId("5298929429");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);

        //创建OrderDetail集合对象
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        Item item = new Item();     // 此处并没有商品的数据，需要调用商品微服务获取
        item.setId(1L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        Item item2 = new Item();    //构造第二个商品数据
        item2.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item2));

        //将OrderDetail数据集设置给Order对象
        order.setOrderDetails(orderDetails);

        //将Order对象添加到Map中
        MAP.put(order.getOrderId(), order);
    }

    public Order queryOrderById(String orderId) {
        Order order = MAP.get(orderId);
        // 获取Order中的OrderDetail列表数据,
        // 然后遍历集合获取每一个OrderDetail,然后调用商品微服务根据商品的id查询商品数据
        for (OrderDetail orderDetail: order.getOrderDetails()) {
            Item item = itemService.queryById(orderDetail.getItem().getId());
            orderDetail.setItem(item);
            
        }
        return order;
    }

}
