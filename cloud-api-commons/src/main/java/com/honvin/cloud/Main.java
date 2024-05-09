package com.honvin.cloud;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.ZonedDateTime;

/**
 * @ClassName: ${NAME}
 * @Date: 2024/4/21 20:23
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@EnableFeignClients
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}