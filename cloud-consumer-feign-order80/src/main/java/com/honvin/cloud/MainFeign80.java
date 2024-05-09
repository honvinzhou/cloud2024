package com.honvin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/4/22 19:43
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients  // 启用feign客户端,定义服务+绑定接口，以声明式的方法优雅而简单的实现服务调用
public class MainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign80.class,args);
    }
}