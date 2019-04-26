package com.ccb.springcloud.comsumer.service.impl;

import com.ccb.springcloud.comsumer.common.mapper.OrderDetailMapper;
import com.ccb.springcloud.comsumer.common.mapper.OrderMapper;
import com.ccb.springcloud.comsumer.common.model.Order;
import com.ccb.springcloud.comsumer.common.model.OrderDetail;
import com.ccb.springcloud.comsumer.io.OrderInfo;
import com.ccb.springcloud.comsumer.service.OrderService;
import com.ccb.springcloud.provider.common.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ItemServiceRemote itemServiceRemote;    //将查询商品服务注进来

    @Override
    public OrderInfo queryOrderById(Integer id) {
        OrderInfo orderInfo = new OrderInfo();

        //查询订单数据
        Order order = orderMapper.selectByPrimaryKey(id);

        //商品列表
        List<Item> itemList = new ArrayList<>();

        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(id);
        for (OrderDetail orderDetail:orderDetails) {
            Item item = itemServiceRemote.queryItemById(orderDetail.getItemId());
            itemList.add(item);
        }

        orderInfo.setOrderId(order.getId());
        orderInfo.setUserId(order.getUserId());
        orderInfo.setUserName(order.getUserName());
        orderInfo.setCreateTime(order.getCreateTime());
        orderInfo.setUpdateTime(order.getUpdateTime());
        orderInfo.setItems(itemList);

        return orderInfo;
    }

}
