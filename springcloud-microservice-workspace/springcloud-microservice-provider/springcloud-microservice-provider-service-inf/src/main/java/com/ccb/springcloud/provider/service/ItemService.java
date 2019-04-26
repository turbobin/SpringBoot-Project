package com.ccb.springcloud.provider.service;

import com.ccb.springcloud.provider.common.model.Item;

public interface ItemService {

    /**
     * 模拟实现商品查询
     */
    Item queryItemById(Integer id);
}
