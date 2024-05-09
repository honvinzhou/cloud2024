package com.honvin.cloud.service;

import com.honvin.cloud.entities.Pay;

import java.util.List;

/**
 * @ClassName: PayService
 * @Date: 2024/4/21 16:21
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
public interface PayService {

    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);
    public List<Pay> getAll();
}
