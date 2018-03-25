package com.clover.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 商品信息
 * Created by wuzhentao
 * 2018/3/23 22:57
 */
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfos;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfoVO> productInfos) {
        this.productInfos = productInfos;
    }
}
