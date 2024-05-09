package com.honvin.cloud.controller;

import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StorageController
 * @Date: 2024/5/9 20:21
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功");
    }
}
