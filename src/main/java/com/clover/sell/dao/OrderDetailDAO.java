package com.clover.sell.dao;

import com.clover.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wuzhentao
 * 2018/3/24 15:02
 */
public interface OrderDetailDAO extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
