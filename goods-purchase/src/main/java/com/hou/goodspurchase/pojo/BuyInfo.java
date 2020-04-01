package com.hou.goodspurchase.pojo;

import org.apache.ibatis.type.Alias;

@Alias("butInfo")
public class BuyInfo {
    private String id;
    private String userId;
    private String productId;
    private Integer num;
    private Double totalPrice;
    private String buyTime;
    private String remark;


    public BuyInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BuyInfo(String id, String userId, String productId, Integer num, Double totalPrice, String remark) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.num = num;
        this.totalPrice = totalPrice;
        this.remark = remark;
    }


}
