package com.honvin.cloud.controller;

import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AccountController
 * @Date: 2024/5/9 20:33
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @param userId
     * @param money 本次消费金额
     * @return
     */
    @RequestMapping("account/decrease")
    public ResultData decrease(Long userId, Long money) {
        accountService.decrease(userId, money);
        return ResultData.success("扣减账户成功！");
    }
}
