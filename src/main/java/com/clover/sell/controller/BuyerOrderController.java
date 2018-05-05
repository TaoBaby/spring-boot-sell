package com.clover.sell.controller;

import com.clover.sell.constants.ResultEnum;
import com.clover.sell.converter.OrderConvert;
import com.clover.sell.dto.OrderDTO;
import com.clover.sell.exception.SellException;
import com.clover.sell.form.OrderForm;
import com.clover.sell.service.BuyerService;
import com.clover.sell.service.OrderService;
import com.clover.sell.utils.ResponseDataUtil;
import com.clover.sell.vo.ResponseDataVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuzhentao
 * 2018/3/30 20:33
 */
@RestController
@RequestMapping(value = "buyer/order")
public class BuyerOrderController {
    private final Logger log = LoggerFactory.getLogger(BuyerOrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping(value = "create")
    public ResponseDataVO<?> createOrder(@Validated OrderForm orderForm,
                                         BindingResult result){
        if(result.hasErrors()){
            log.error("【创建订单】订单参数不正确，orderForm = {}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),result.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderConvert.orderFrom2Dto(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderResult = orderService.create(orderDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("orderId",orderResult.getOrderId());
        return ResponseDataUtil.success(map);
    }
    //订单列表
    @GetMapping(value = "list")
    public ResponseDataVO<?> findList(@RequestParam(value = "openid") String openid,
                                      @RequestParam(value = "page", defaultValue = "0")Integer page,
                                      @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(openid == null){
            log.error("【获取订单列表】 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResponseDataUtil.success(orderDTOPage.getContent());
    }

    //取消订单
    @GetMapping(value = "cancel")
    public ResponseDataVO<?> cancel(@RequestParam(value = "openid") String openid,
                                    @RequestParam(value = "orderId") String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResponseDataUtil.success();
    }


    //订单详情
    @GetMapping(value = "detail")
    public ResponseDataVO<?> detail(@RequestParam(value = "openid") String openid,
                                    @RequestParam(value = "orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResponseDataUtil.success(orderDTO);
    }
}
