package com.honvin.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.honvin.cloud.apis.PayFeignApi;
import com.honvin.cloud.entities.PayDTO;
import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName: OrderController
 * @Date: 2024/4/21 19:23
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        log.info("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");

        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        log.info("-------支付微服务远程调用，按照id查询订单支付流水信息");

        ResultData payInfo = null;

        try {
            log.info("调用开始----------" + DateUtil.now());
            payInfo = payFeignApi.getPayInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("调用失败----------" + DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }

        return payInfo;
    }

    /**
     * openfeign天然支持负载均衡演示
     * @return
     */
    @GetMapping("/feign/pay/mylb")
    public String mylb() {

        return payFeignApi.mylb();
    }
}
