package com.clover.sell.converter;

import com.clover.sell.dataobject.OrderMaster;
import com.clover.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wuzhentao
 * 2018/3/26 22:23
 */
public class OrderConvert {
    public static List<OrderDTO> orderMasterList2Dto(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> orderMaster2Dto(e)).collect(Collectors.toList());
    }

    public static OrderDTO orderMaster2Dto(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }
}
