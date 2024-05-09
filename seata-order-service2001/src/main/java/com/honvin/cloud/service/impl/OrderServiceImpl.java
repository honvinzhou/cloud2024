package com.honvin.cloud.service.impl;

import com.honvin.cloud.apis.AccountFeignApi;
import com.honvin.cloud.apis.StorageFeignApi;
import com.honvin.cloud.entities.Order;
import com.honvin.cloud.mapper.OrderMapper;
import com.honvin.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName: OrderServiceImpl
 * @Date: 2024/5/9 19:43
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageFeignApi storageFeignApi;  // 订单微服务通过OpenFeign去调用库存微服务
    @Resource
    private AccountFeignApi accountFeignApi;  // 订单微服务通过OpenFeign去调用账户微服务

    @Override
    @GlobalTransactional(name = "honvin-create-order",rollbackFor = Exception.class)  // AT
    public void create(Order order) {
        // xid全局事务id的检查，重要
        String xid = RootContext.getXID();
        // 1. 新建订单
        log.info("---------------->开始新建订单:" + "\t" + "xid:" + xid);
        // 订单新建是默认初始订单状态为0
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        // 插入订单成功后获得插入mysql的实体对象
        Order orderFromDB = null;

        if (result > 0) {
            // 从mysql里卖弄查出刚插入的记录
            orderFromDB = orderMapper.selectOne(order);
            log.info("----->新建订单成功,orderFromDB info: " + orderFromDB);
            System.out.println();
            // 2. 扣减库存
            log.info("----->的订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDB.getProductId(), orderFromDB.getCount());
            log.info("----->的订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            // 3. 扣减账户余额
            log.info("----->的订单微服务开始调用Account账户，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(), orderFromDB.getMoney());
            log.info("----->的订单微服务结束调用Account账户，做扣减完成");
            System.out.println();

            // 修改订单状态为1,表示已经完成
            log.info("----->修改订单状态");
            orderFromDB.setStatus(1);

            Example whereCondition = new Example(Order.class);
            Example.Criteria criteria = whereCondition.createCriteria();
            criteria.andEqualTo("userId", orderFromDB.getUserId());
            criteria.andEqualTo("status", 0);

            int updateResult = orderMapper.updateByExampleSelective(orderFromDB, whereCondition);
            log.info("----->修改订单状态结果:\t" + updateResult);
            log.info("----->orderFromDB info:" + orderFromDB);
        }
        System.out.println();
        log.info("---------------->新建订单结束:" + "\t" + "xid:" + xid);

    }
}
