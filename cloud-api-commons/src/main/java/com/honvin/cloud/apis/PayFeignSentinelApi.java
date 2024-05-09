package com.honvin.cloud.apis;

import com.honvin.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: PayFeignSentinelApi
 * @Date: 2024/5/8 20:30
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallback.class)
public interface PayFeignSentinelApi {

    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
