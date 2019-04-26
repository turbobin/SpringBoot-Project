package com.ccb.springcloud.provider.service.controller;

import com.ccb.springcloud.provider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public Object queryItemById(@PathVariable("id") Integer id) {
        return itemService.queryItemById(id);
    }
}
