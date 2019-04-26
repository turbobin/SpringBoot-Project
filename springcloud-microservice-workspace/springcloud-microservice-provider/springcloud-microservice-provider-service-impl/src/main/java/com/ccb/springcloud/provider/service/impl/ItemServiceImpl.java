package com.ccb.springcloud.provider.service.impl;

import com.ccb.springcloud.provider.common.mapper.ItemMapper;
import com.ccb.springcloud.provider.common.model.Item;
import com.ccb.springcloud.provider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item queryItemById(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
