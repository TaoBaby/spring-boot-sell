package com.clover.sell.dao;

import com.clover.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by wuzhentao
 * 2018/3/23 21:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDAOTest {
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Test
    public void addTest(){
        ProductInfo info = new ProductInfo();
        info.setProductId("123456");
        info.setCategoryType(2);
        info.setProductDescription("漂亮的衣服");
        info.setProductIcon("http://XXX/info.jpa");
        info.setProductName("衣服");
        info.setProductPrice(new BigDecimal(100));
        info.setProductStatus(1);
        info.setProductStock(100);

        ProductInfo result = productInfoDAO.save(info);
        Assert.assertNotNull(result);
    }

}