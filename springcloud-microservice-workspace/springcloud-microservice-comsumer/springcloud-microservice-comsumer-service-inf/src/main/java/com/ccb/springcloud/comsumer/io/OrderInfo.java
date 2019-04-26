package com.ccb.springcloud.comsumer.io;

import com.ccb.springcloud.provider.common.model.Item;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 返回对象实体类
 */
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer userId;

    private String userName;

    private Date createTime;

    private Date updateTime;

    private List<Item> items;   //商品列表

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
