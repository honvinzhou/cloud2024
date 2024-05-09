package com.honvin.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FlowLimitService
 * @Date: 2024/5/7 16:38
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common() {
        System.out.println("------FlowLimitService come in");
    }
}
