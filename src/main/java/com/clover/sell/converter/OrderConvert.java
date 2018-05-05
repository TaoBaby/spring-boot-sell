package com.clover.sell.converter;

import com.clover.sell.constants.ResultEnum;
import com.clover.sell.dataobject.OrderDetail;
import com.clover.sell.dataobject.OrderMaster;
import com.clover.sell.dto.OrderDTO;
import com.clover.sell.exception.SellException;
import com.clover.sell.form.OrderForm;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wuzhentao
 * 2018/3/26 22:23
 */
public class OrderConvert {
    private static final Logger log = LoggerFactory.getLogger(OrderConvert.class);
    public static List<OrderDTO> orderMasterList2Dto(List<OrderMaster> orderMasterList) {
       return orderMasterList.stream().map(e -> orderMaster2Dto(e)).collect(Collectors.toList());
    }

    public static OrderDTO orderMaster2Dto(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static OrderDTO orderFrom2Dto(OrderForm orderForm){
       //Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        List<OrderDetail> orderDetailList = new ArrayList<>();

    /*    try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误，String={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }*/
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }


}
