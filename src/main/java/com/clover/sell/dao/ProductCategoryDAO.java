package com.clover.sell.dao;

import com.clover.sell.dataobject.ProductCategory;
import com.clover.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wuzhentao
 * 2018/3/22 21:01
 */
public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
