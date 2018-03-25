package com.clover.sell.service.impl;

import com.clover.sell.dao.ProductCategoryDAO;
import com.clover.sell.dataobject.ProductCategory;
import com.clover.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目
 * Created by wuzhentao
 * 2018/3/22 23:39
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public ProductCategory findById(Integer categoryId) {
        Optional<ProductCategory> optional = productCategoryDAO.findById(categoryId);
        return optional.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDAO.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDAO.save(productCategory);
    }
}
