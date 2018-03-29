package com.clover.sell.constants;

/**
 * 订单支付状态
 * Created by wuzhentao
 * 2018/3/24 14:33
 */
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "取消");

    private Integer code;
    private String desc;


    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
