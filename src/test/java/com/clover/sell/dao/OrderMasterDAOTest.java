package com.clover.sell.dao;

import com.clover.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by wuzhentao
 * 2018/3/24 15:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDAOTest {

    @Autowired
    private OrderMasterDAO orderMasterDAO;

    private final String OPENID = "abc123";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerAddress("四川成都");
        orderMaster.setBuyerName("吴小米");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("13027187665");
        orderMaster.setOrderAmount(new BigDecimal(20.9));

       OrderMaster result = orderMasterDAO.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenidTest(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> result =  orderMasterDAO.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(result.getTotalElements());
    }
}