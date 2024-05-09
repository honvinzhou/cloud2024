package com.honvin.cloud.service.impl;

import com.honvin.cloud.entities.Pay;
import com.honvin.cloud.mapper.PayMapper;
import com.honvin.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PayServiceImpl
 * @Date: 2024/4/21 16:26
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
