package com.honvin.cloud.service;

/**
 * @ClassName: AccountService
 * @Date: 2024/5/9 20:29
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(Long userId, Long money);
}
