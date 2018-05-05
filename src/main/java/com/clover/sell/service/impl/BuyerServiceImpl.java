package com.clover.sell.service.impl;

import com.clover.sell.constants.ResultEnum;
import com.clover.sell.dto.OrderDTO;
import com.clover.sell.exception.SellException;
import com.clover.sell.service.BuyerService;
import com.clover.sell.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家
 * Created by wuzhentao
 * 2018/3/31 17:42
 */
@Service
public class BuyerServiceImpl implements BuyerService {
    private final Logger log = LoggerFactory.getLogger(BuyerServiceImpl.class);
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
       return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if(orderDTO == null){
            log.error("【取消订单】该订单不存在，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        //查找订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
           return null;
        }
        //判断订单是否是本人
        if(!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDTO;
    }
}
