package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/4/25 21:02
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 服务注册和发现
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class, args);
    }
}