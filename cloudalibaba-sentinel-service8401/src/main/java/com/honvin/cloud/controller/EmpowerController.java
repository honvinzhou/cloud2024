package com.honvin.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmpowerController
 * @Date: 2024/5/7 21:17
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
public class EmpowerController {  // Empower授权规则，用来处理请求的来源

    @GetMapping(value = "/empower")
    public String requestSentinel4() {
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}