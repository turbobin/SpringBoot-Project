package com.ccb.springcloud.comsumer.service.impl;

import com.ccb.springcloud.provider.common.model.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 远程查询商品列表服务
 */
@Service
public class ItemServiceRemote {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    // 查询商品列表
    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")	// 进行容错处理
    Item queryItemById(Integer itemId) {
        // 使用HttpClient工具发送请求获取商品的数据
        // 我们也可以使用spring给我们提供的另个一个类RestTemplate,来发送Http请求
        String itemServiceId = "springcloud-microservice-item";

        //服务发现，返回实例
//        List<ServiceInstance> instances =
//                discoveryClient.getInstances(itemServiceId);
//
////        if (instances == null || instances.isEmpty()) {
////            return null;
////        }
//
//        ServiceInstance instance = instances.get(0);
//        String url = "http://" + instance.getHost()
//                + ":" +instance.getPort() + "/item/";
//        System.out.println("url = [" + url + itemId + "]");
//        Item item = restTemplate.getForObject(url + itemId, Item.class);
//
//        // 返回
//        return item;

        //实现容错后，查询变得简单了
        return restTemplate.getForObject("http://" + itemServiceId + "/item/" + itemId, Item.class);

    }

    /**
     * 断路返回方法
     * @param itemId
     * @return
     */
    private Item queryItemByIdFallbackMethod(Integer itemId) {
        return new Item(itemId, "查询商品信息出错！", null, null, null);
    }
}
