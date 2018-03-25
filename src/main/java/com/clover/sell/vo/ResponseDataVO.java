package com.clover.sell.vo;

/**
 * 返回前端的对象
 * Created by wuzhentao
 * 2018/3/23 22:40
 */
public class ResponseDataVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示消息. */
    private String msg;

    /** 返回对象. */
    private T data;

    public ResponseDataVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseDataVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
