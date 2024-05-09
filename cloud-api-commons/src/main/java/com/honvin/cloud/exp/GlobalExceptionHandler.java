package com.honvin.cloud.exp;

import com.honvin.cloud.resp.ResultData;
import com.honvin.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionHandler
 * @Date: 2024/4/21 18:56
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        System.out.println("全局异常处理");
        log.error("全局异常信息:{}", e.getMessage(), e);

        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
