package com.clover.sell.utils;

import com.clover.sell.vo.ResponseDataVO;

/**
 * Created by wuzhentao
 * 2018/3/24 10:11
 */
public class ResponseDataUtil {
    private static final  int  SUCCESS_CODE = 0 ;
    private static final  String  SUCCESS_msg = "成功" ;

    public static ResponseDataVO success(Object data){
        return new ResponseDataVO(SUCCESS_CODE, SUCCESS_msg, data);
    }
    public static ResponseDataVO success(){
        return success(null);
    }

    public static ResponseDataVO error(Integer code, String msg){
        return new ResponseDataVO(code, msg);
    }

}
