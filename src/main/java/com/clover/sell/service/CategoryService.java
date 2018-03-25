package com.clover.sell.service;

import com.clover.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目
 * Created by wuzhentao
 * 2018/3/22 23:38
 */
public interface CategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
