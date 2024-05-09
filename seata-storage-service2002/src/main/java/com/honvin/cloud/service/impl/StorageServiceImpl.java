package com.honvin.cloud.service.impl;

import com.honvin.cloud.mapper.StorageMapper;
import com.honvin.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StorageServiceImpl
 * @Date: 2024/5/9 20:20
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
