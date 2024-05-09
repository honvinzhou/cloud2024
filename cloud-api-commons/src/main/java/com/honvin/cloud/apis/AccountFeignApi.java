package com.honvin.cloud.apis;

import com.honvin.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: AccountFeignApi
 * @Date: 2024/5/9 19:25
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {

    /**
     * 减余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
