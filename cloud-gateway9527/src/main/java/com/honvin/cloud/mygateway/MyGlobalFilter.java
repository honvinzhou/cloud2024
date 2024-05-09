package com.honvin.cloud.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName: MyGlobalFilter
 * @Date: 2024/4/27 21:33
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    private static final String BEGIN_VISIT_TIME = "begin-visit-time";

    /**
     * 统计各种信息
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 先记录下访问接口的开始时间
        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());
        // 2. 返回统计的各个结果给后台
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
            if (beginVisitTime != null) {
                log.info("访问接口主机: {}", exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: {}", exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: {}", exchange.getRequest().getURI().getPath());
                log.info("访问接口URL后面的参数: {}", exchange.getRequest().getURI().getRawQuery());
                log.info("接口访问耗时: {}ms", System.currentTimeMillis() - beginVisitTime);
                log.info("========================================================");
                System.out.println();
            }
        }));
    }

    /**
     * 数字越小，优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
