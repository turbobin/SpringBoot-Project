package com.ccb.springcloud.provider.common.model;

public class Item {
    private Integer id;

    private String title;

    private String picture;

    private String description;

    private Integer price;

    public Item() {
    }

    public Item(Integer id, String title, String picture, String description, Integer price) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}