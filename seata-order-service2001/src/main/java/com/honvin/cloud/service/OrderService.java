package com.honvin.cloud.service;

import com.honvin.cloud.entities.Order;

/**
 * @ClassName: OrderService
 * @Date: 2024/5/9 19:42
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}