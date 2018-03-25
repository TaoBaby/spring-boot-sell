package com.clover.sell.service.impl;

import com.clover.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wuzhentao
 * 2018/3/23 22:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productInfoService;


    @Test
    public void findOne() {
       ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
       List<ProductInfo> data =  productInfoService.findUpAll();
       Assert.assertTrue(data.size() > 0);
    }

    @Test
    public void findAll() {
        PageRequest page = new PageRequest(0,2);
        Page<ProductInfo> data = productInfoService.findAll(page);
        Assert.assertNotNull(data);
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("23456");
        info.setCategoryType(3);
        info.setProductDescription("漂亮的鞋子");
        info.setProductIcon("http://XXX/info.jpa");
        info.setProductName("鞋子");
        info.setProductPrice(new BigDecimal(200));
        info.setProductStatus(1);
        info.setProductStock(100);

       ProductInfo productInfo = productInfoService.save(info);
       Assert.assertNotNull(productInfo);
    }
}