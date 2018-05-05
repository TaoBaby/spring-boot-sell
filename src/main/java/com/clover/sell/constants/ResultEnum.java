package com.clover.sell.constants;

/**
 * 结果异常
 * Created by wuzhentao
 * 2018/3/24 17:04
 */
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"更新失败"),
    ORDER_OWER_ERROR(16,"不是本人的订单"),
    ORDER_FINISHED_FAIL(17,"完结订单失败"),
    ORDER_PAY_STATUS_ERROR(18,"支付状态不正确"),
    CART_EMPTY(19,"购物车为空"),

    ;


    private Integer code;
    private String desc;

    ResultEnum(Integer code, String desc) {
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
