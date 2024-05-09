package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/5/9 20:24
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.honvin.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
public class SeataAccountMainApp2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}