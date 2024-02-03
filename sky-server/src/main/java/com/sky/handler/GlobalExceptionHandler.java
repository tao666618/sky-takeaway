package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;


/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler //注解意思是捕获SQLIntegrityConstraintViolationException异常
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error("数据库插入异常：{}", ex.getMessage());
        String massage = ex.getLocalizedMessage();
        if (massage.contains("Duplicate entry")) {
            return Result.error(MessageConstant.ACCOUNT_EXIST);
        }
        else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }

    }

}
