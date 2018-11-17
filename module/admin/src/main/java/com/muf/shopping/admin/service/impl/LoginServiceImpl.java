package com.muf.shopping.admin.service.impl;

import com.muf.shopping.common.web.utils.HttpContextUtils;
import com.muf.shopping.common.web.utils.IPUtils;
import com.muf.shopping.common.web.utils.TokenUtils;
import com.muf.shopping.admin.dto.LoginUserDTO;
import com.muf.shopping.admin.service.LoginService;
import com.muf.shopping.admin.service.ShiroService;
import com.muf.shopping.common.base.constant.Constant;
import com.muf.shopping.common.redis.utils.RedisKeys;
import com.muf.shopping.common.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 
 * @author: hutao
 * @date 2018/11/16 16:48
 */
@Service("loginService")
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ShiroService shiroService;


    /**
     * 根据用户和密码获取用户信息
     */
    @Override
    public LoginUserDTO getUserByPhone(String phone, String password) {
        //用户信息
        LoginUserDTO user = shiroService.findByPhone(phone);
        return user;
    }


    /**
     * 登录成功回调
     */
    @Override
    public LoginUserDTO doLogin(LoginUserDTO user) {
        //签发用户token
        String token = TokenUtils.createToken(user.getUserId(), user.getUserName(), Constant.JWT_SIGN_KEY);
        user.setToken(token);
        user.setJti(TokenUtils.tokenInfo(token, Constant.JWT_ID, String.class));
        // user.setAvatar(Optional.ofNullable(user.getAvatar()).map(s -> OSSFactory.ali().generatePresignedUrl(s, 86400)).orElse(null));
        //用户信息放入redis中dddd
        redisUtils.set(RedisKeys.User.token(user.getUserId()), user, TokenUtils.getProlong());
        //清除用户授权缓存
        redisUtils.delete(RedisKeys.User.perm(user.getUserId()));
        //更新本次登录IP信息
        shiroService.updateUserLoginInfo(user, IPUtils.getIpAddr(HttpContextUtils.getHttpServletRequest()));
        //保存登录日志
        //sysLogService.save(user.getUserName(), "用户登录", getClass().getCanonicalName(), user);
        return user;
    }



}
