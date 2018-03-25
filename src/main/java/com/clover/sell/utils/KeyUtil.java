package com.clover.sell.utils;

import java.util.Random;

/**
 * 生成主键
 * Created by wuzhentao
 * 2018/3/24 17:45
 */
public class KeyUtil {
    /**
     * 生成随机主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
