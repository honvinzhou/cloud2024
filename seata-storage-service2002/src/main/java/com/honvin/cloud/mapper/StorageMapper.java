package com.honvin.cloud.mapper;

import com.honvin.cloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface StorageMapper extends Mapper<Storage> {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}