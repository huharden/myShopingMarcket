package com.muf.shopping.admin.api;


import com.muf.shopping.base.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * description: 用于后端服务间的调用
 * @author: hutao
 * @date 2018/11/16 15:27
 */
@RestController
@RequestMapping(Constant.API_PATH + "/auth")
@Slf4j
public class SysAuthApi {

    /*private final AuthService authService;

    @Autowired
    public SysAuthApi(AuthService authService) {
        this.authService = authService;
    }

    *//**
     * 校验token，通过返回角色和权限信息
     *//*
    @GetMapping(value = "/check/{userId}/{jti}")
    public AuthCheckResult checkToken(@PathVariable("userId") Long userId, @PathVariable("jti") String jti) {
        return authService.checkToken(userId, jti);
    }

    *//**
     * 查找用户编号对应的角色编码字符串
     *//*
    @PostMapping(value = "/getUserRoleSet/{userId}")
    public Set<String> getUserRoleSet(@PathVariable Long userId) {
        return authService.roleSet(userId);
    }

    *//**
     * 查找用户编号对应的权限编码字符串
     *//*
    @PostMapping(value = "/getUserPermSet/{userId}")
    public Set<String> getUserPermSet(@PathVariable Long userId) {
        return authService.permSet(userId);
    }
*/
    @GetMapping(value = "/feignTest/{userId}")
    public void feignTest(@PathVariable Long userId){
        System.out.println("Feign测试"+userId);
    }
}
