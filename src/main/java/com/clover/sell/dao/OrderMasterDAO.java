package com.clover.sell.dao;

import com.clover.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wuzhentao
 * 2018/3/24 14:56
 */
public interface OrderMasterDAO extends JpaRepository<OrderMaster, String>{
    Page<OrderMaster> findByBuyerOpenid(String openid, Pageable pageable);
}
