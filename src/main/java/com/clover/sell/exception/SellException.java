package com.clover.sell.exception;

import com.clover.sell.constants.ResultEnum;

/**
 * Created by wuzhentao
 * 2018/3/24 16:57
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = code;
    }
}
