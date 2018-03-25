package com.clover.sell.service.impl;

import com.clover.sell.constants.ProductEnum;
import com.clover.sell.constants.ResultEnum;
import com.clover.sell.dao.ProductInfoDAO;
import com.clover.sell.dataobject.ProductInfo;
import com.clover.sell.dto.CartDTO;
import com.clover.sell.exception.SellException;
import com.clover.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

/**
 * Created by wuzhentao
 * 2018/3/23 21:55
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDAO.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDAO.findByProductStatus(ProductEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDAO.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDAO.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transient
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoDAO.findById(cartDTO.getProductId()).get();
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDAO.save(productInfo);
        }

    }
}
