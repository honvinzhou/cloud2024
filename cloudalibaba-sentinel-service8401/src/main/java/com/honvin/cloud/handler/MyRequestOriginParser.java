package com.honvin.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyRequestOriginParser
 * @Date: 2024/5/7 21:18
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Component
public class MyRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("serverName");
    }
}
