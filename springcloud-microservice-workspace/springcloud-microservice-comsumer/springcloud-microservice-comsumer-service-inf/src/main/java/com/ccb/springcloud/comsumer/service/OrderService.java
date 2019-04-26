package com.ccb.springcloud.comsumer.service;

import com.ccb.springcloud.comsumer.io.OrderInfo;

public interface OrderService {

    // 查询单笔订单数据
    OrderInfo queryOrderById(Integer id);
}
