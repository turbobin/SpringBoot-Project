package com.ccb.springboot.order.service;

import com.ccb.springboot.order.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * 测试负载均衡，默认是轮询机制
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class ItemServiceTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        String serviceId = "ccb-springboot-item";
        for (int i = 0; i < 50; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第" + i + "次" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        }
    }

}