package com.muf.shopping.admin.controller;


import com.muf.shopping.admin.dto.LoginUserDTO;
import com.muf.shopping.admin.service.LoginService;
import com.muf.shopping.common.base.utils.R;
import com.muf.shopping.common.redis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * description: 登陆测试
 * @author: hutao
 * @date 2018/11/16 16:29
 */
@RestController
@RequestMapping("/")
public class LoginController{
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 登录
     */
       @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody LoginUserDTO userDTO) {
           String key = "12";
           if("".equals(redisUtils.fuzzyKey(key))){
                redisUtils.set(key, "12455");
           }
        //验证用户登录
        LoginUserDTO user = loginService.getUserByPhone(userDTO.getPhone(), userDTO.getPassword());
        return R.ok(loginService.doLogin(user));
    }


}
