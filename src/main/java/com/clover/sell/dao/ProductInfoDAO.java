package com.clover.sell.dao;

import com.clover.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wuzhentao
 * 2018/3/23 21:04
 */
public interface ProductInfoDAO extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
