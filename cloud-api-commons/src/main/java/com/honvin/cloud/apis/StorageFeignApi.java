package com.honvin.cloud.apis;

import com.honvin.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: StorageFeignApi
 * @Date: 2024/5/9 19:22
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {

    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping("/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
