package com.clover.sell.form;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wuzhentao
 * 2018/3/30 20:53
 */
public class OrderForm {
    /** 买家名称 */
    @NotEmpty(message = "买家姓名必填")
    private String name;

    /** 买家手机 */
    @NotEmpty(message = "买家电话必填")
    private String phone;

    /** 买家地址 */
    @NotEmpty( message = "买家地址必填")
    private String address;

    /** 用户微信 open id */
    @NotEmpty(message = "openid 必填")
    private String openid;

    /** 订单详情*/
    @NotEmpty(message = "购物车不能为空")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
