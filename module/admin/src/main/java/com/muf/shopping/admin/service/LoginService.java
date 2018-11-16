package com.muf.shopping.admin.service;

import com.muf.shopping.admin.dto.LoginUserDTO;

/**
 * 用户登录逻辑
 *
 * @author : heshuangshuang
 * @date : 2018/5/23 9:32
 */
public interface LoginService {

    /**
     * 根据用户和密码获取用户信息
     */
    LoginUserDTO getUserByPhone(String phone, String password);

    /**
     * 执行登录逻辑
     */
    LoginUserDTO doLogin(LoginUserDTO userDTO);

}
