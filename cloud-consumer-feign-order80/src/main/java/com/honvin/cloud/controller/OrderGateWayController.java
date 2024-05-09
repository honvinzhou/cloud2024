package com.honvin.cloud.controller;

import com.honvin.cloud.apis.PayFeignApi;
import com.honvin.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderGateWayController
 * @Date: 2024/4/25 21:39
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
public class OrderGateWayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }
}
