package com.clover.sell.controller;

import com.clover.sell.dataobject.ProductCategory;
import com.clover.sell.dataobject.ProductInfo;
import com.clover.sell.service.CategoryService;
import com.clover.sell.service.ProductService;
import com.clover.sell.utils.ResponseDataUtil;
import com.clover.sell.vo.ProductInfoVO;
import com.clover.sell.vo.ProductVO;
import com.clover.sell.vo.ResponseDataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by wuzhentao
 * 2018/3/23 22:38
 */
@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET} )
    public ResponseDataVO<?> getList(){
        //查找所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //精简方法 java8、lambda
        List<Integer> categoryTypeList =productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //查找所有类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //一行代替
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfos(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResponseDataUtil.success(productVOList);
    }


}
