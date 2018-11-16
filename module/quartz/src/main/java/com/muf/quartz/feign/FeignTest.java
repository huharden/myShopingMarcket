package com.muf.quartz.feign;

import com.muf.quartz.feign.impl.FeignTestImpl;
import com.muf.shopping.common.base.constant.Constant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-16-14:11
 */
@FeignClient(name = "shopping-admin", fallback = FeignTestImpl.class)
public interface FeignTest {
    /**
     * 通过用户名查询用户、角色信息
     */
    @RequestMapping(value = Constant.API_PATH + "/auth/feignTest/{userId}", method = RequestMethod.GET)
    void feignTest(@PathVariable("userId") Long userId);

}
