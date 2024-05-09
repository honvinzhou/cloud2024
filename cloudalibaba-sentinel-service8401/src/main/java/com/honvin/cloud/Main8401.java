package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/4/28 21:48
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Main8401 {

    public static void main(String[] args) {
        SpringApplication.run(Main8401.class, args);
    }
}