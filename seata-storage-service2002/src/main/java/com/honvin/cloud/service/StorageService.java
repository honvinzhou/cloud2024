package com.honvin.cloud.service;

/**
 * @ClassName: StorageService
 * @Date: 2024/5/9 20:20
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
