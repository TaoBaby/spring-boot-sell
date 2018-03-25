package com.clover.sell.dao;

import com.clover.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuzhentao
 * 2018/3/22 21:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {
    @Autowired
    private ProductCategoryDAO dao;

    @Test
    public void findOneTest(){
      //ProductCategory productCategory = repository.findById(1);
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("家具用品");
        productCategory.setCategoryType(5);
        dao.save(productCategory);
    }

    @Test
    public void findByCategoryType(){
        List<Integer> typeList = Arrays.asList(2,3,4);
        List<ProductCategory> result = dao.findByCategoryTypeIn(typeList);
        Assert.assertNotEquals(0,result.size());
    }


}

