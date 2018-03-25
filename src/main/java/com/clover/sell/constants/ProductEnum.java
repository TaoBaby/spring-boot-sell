package com.clover.sell.constants;

/**
 * Created by wuzhentao
 * 2018/3/23 22:05
 */
public enum ProductEnum {
    UP(0,"上架"),DOWN(1, "下架");

    private final Integer code;
    private final String desc;

    ProductEnum(final Integer code, final String desc) {
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
