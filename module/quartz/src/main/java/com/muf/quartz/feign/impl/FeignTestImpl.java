package com.muf.quartz.feign.impl;


import com.muf.quartz.feign.FeignTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description: Feign处理类
 * @author: hutao
 * @date 2018/11/16 14:23
 */
@Service
@Slf4j
public class FeignTestImpl implements FeignTest {

    @Override
    public void feignTest(Long userId){
        log.error("调用{}异常:{},{}", "checkToken", userId);

    }
}
