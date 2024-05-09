package com.honvin.cloud.mapper;

import com.honvin.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {

    /**
     * 扣减账户余额
     * @param userId
     * @param money 本次消费金融
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}