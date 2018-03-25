package com.clover.sell.service.impl;

import com.clover.sell.dataobject.OrderDetail;
import com.clover.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuzhentao
 * 2018/3/24 18:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);
    @Autowired
    private OrderServiceImpl orderService;

    private final  String openid = "20134223";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO() ;
        orderDTO.setBuyerAddress("成都");
        orderDTO.setBuyerName("智慧");
        orderDTO.setBuyerOpenid(openid);
        orderDTO.setBuyerPhone("13028765656");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123457");
        orderDetail.setProductQuantity(10);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        logger.info("【创建订单】result={}",result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}