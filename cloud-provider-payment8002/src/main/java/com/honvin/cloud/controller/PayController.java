package com.honvin.cloud.controller;

import com.honvin.cloud.entities.Pay;
import com.honvin.cloud.entities.PayDTO;
import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: PayController
 * @Date: 2024/4/21 16:32
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "提供支付流水相关的增删改查接口")
public class PayController {

    @Resource
    private PayService payService;

    /**
     * 创建支付流水
     * @param pay
     * @return
     */
    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info("addPay: " + pay);

        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    /**
     * 按照主键删除一条记录
     * @param id
     * @return
     */
    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<String> delPay(@PathVariable("id") Integer id) {
        log.info("delPay: " + id);

        int i = payService.delete(id);
        return ResultData.success("成功删除记录，返回值：" + i);
    }

    /**
     * 按照主键修改一条记录
     * @param payDTO
     * @return
     */
    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        log.info("updatePay: " + payDTO);

        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    /**
     * 按照主键查询支付流水
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        log.info("getById: " + id);

        if(id == -4) throw new RuntimeException("id不能为负数");

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    /**
     * 查询所有流水
     * @return
     */
    @GetMapping("/pay/getAll")
    @Operation(summary = "查询所有流水",description = "查询所有支付流水方法")
    public ResultData<List<Pay>> getAll() {
        log.info("getAll");

        List<Pay> list = payService.getAll();
        return ResultData.success(list);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${honvin.info}") String honvinInfo) {
        return "当前端口：" + port + "，当前配置文件信息：" + honvinInfo;
    }
}
