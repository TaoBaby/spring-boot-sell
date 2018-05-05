package com.clover.sell.service;

import com.clover.sell.dto.OrderDTO;

/**
 * 买家
 * Created by wuzhentao
 * 2018/3/31 17:40
 */
public interface BuyerService {
    //查询订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
