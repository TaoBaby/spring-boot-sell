package com.clover.sell.dao;

import com.clover.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuzhentao
 * 2018/3/24 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDAOTest {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234100");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("2221111");
        orderDetail.setProductName("苹果");
        orderDetail.setProductPrice(new BigDecimal(5.8));
        orderDetail.setProductQuantity(100);

        OrderDetail result = orderDetailDAO.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdTest(){
       List<OrderDetail> result =  orderDetailDAO.findByOrderId("123452");
       Assert.assertEquals(0,result.size());
    }

}