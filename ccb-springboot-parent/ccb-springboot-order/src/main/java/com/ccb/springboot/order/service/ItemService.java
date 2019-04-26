package com.ccb.springboot.order.service;

import com.ccb.springboot.order.pojo.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {

    private static final Map<Long, Item> MAP = new HashMap<Long, Item>();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 模拟实现商品查询
     */
    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")     //进行容错处理
    Item queryById(Long id) {
        // 使用HttpClient工具发送请求获取商品的数据
        // 我们也可以使用spring给我们提供的另个一个类RestTemplate,来发送Http请求
        String itemServiceId = "ccb-springboot-item";
//        List<ServiceInstance> instances = discoveryClient.getInstances(itemServiceId);
//
//        if (instances == null || instances.isEmpty()) {
//            return null;
//        }
//
//        ServiceInstance instance = instances.get(0);
//        String url = "http://" + instance.getHost() + ":" +instance.getPort() + "/item/";
//        System.out.println("url = [" + url + "]");
//        Item item = restTemplate.getForObject(url + id, Item.class);
//
//        // 返回
//        return item;

        //实现容错后，实现变得简单了
        return restTemplate.getForObject("http://" + itemServiceId + "/item/" + id, Item.class);

    }

    private Item queryItemByIdFallbackMethod(Long id){ 											// 请求失败执行的方法
        return new Item(id, "查询商品信息出错!", null, null, null);
    }


}
