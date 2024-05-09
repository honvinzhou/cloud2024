package com.honvin.cloud.apis;

import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PayFeignSentinelApiFallback
 * @Date: 2024/5/8 20:33
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi {

    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，Fallback服务降级/(ㄒoㄒ)/~~");
    }
}
