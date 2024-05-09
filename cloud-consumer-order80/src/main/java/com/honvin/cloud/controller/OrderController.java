package com.honvin.cloud.controller;

import com.honvin.cloud.entities.PayDTO;
import com.honvin.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName: OrderController
 * @Date: 2024/4/21 19:23
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@RestController
@Slf4j
public class OrderController {

//    public static final String PaymentSrv_URL = "http://localhost:8001";  // 先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";  // 服务注册上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    /**
     * 调用增加流水服务
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        log.info("调用增加流水服务:{}", payDTO);

        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    /**
     * 调用删除流水服务
     * @param id
     * @return
     */
    @GetMapping("/consumer/pay/del/{id}")
    public ResultData delOrder(@PathVariable("id") Integer id) {
        log.info("调用删除流水服务:{}", id);

        restTemplate.delete(PaymentSrv_URL + "/pay/del/" + id);
        return ResultData.success("成功删除记录");
    }

    /**
     * 调用更新流水服务
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        log.info("调用更新流水服务:{}", payDTO);

        restTemplate.put(PaymentSrv_URL + "/pay/update", payDTO);
        return ResultData.success("成功修改记录");
    }

    /**
     * 调用查询流水服务
     * @param id
     * @return
     */
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        log.info("调用查询流水服务:{}", id);

        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class);
    }


    /**
     * 调用查询所有流水服务
     * @return
     */
    @GetMapping("/consumer/pay/getAll")
    public ResultData getAllPayInfo() {
        log.info("调用查询所有流水服务");

        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll", ResultData.class);
    }

    /**
     * 调用查询info服务
     * @return
     */
    @GetMapping("/consumer/pay/get/info")
    private String getInfoByConsul() {
        log.info("调用查询info服务");

        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
