package com.honvin.cloud.controller;

import com.honvin.cloud.entities.Order;
import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Controller
 * @Date: 2024/5/9 20:05
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}
