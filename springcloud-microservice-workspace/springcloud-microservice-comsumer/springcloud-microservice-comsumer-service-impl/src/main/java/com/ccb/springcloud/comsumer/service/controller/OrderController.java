package com.ccb.springcloud.comsumer.service.controller;

import com.ccb.springcloud.comsumer.io.OrderInfo;
import com.ccb.springcloud.comsumer.service.OrderService;
import com.ccb.springcloud.comsumer.service.impl.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{orderId}")
    public OrderInfo queryOrderById(@PathVariable("orderId") Integer orderId) {
        return this.orderService.queryOrderById(orderId);
    }

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "hello")
    public String hello() {
        return helloService.hello();
    }

}
