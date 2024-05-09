package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/5/9 19:36
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.honvin.cloud.mapper")
@EnableFeignClients
public class SeataOrderMainApp2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class, args);
    }
}