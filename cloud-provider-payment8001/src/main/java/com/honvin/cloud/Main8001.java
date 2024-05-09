package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/4/21 16:07
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootApplication
@MapperScan("com.honvin.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope  // 动态刷新
public class Main8001 {

    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }

}