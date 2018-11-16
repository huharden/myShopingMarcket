package com.muf.shopping.admin.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : heshuangshuang
 * @date : 2018/1/18 22:06
 */
@Data
public class LoginUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号码 唯一索引 phone
     **/
    private String phone;

    /**
     * 盐
     */
    @JSONField(serialize = false)
    private String salt;

    /**
     * 用户密码 password
     **/
    @JSONField(serialize = false)
    private String password;

    /**
     * 头像 avatar
     **/
    private String avatar;

    /**
     * 状态 0正常 1禁用 status
     **/
    @JSONField(serialize = false)
    private Integer status;

    /**
     * 创建者ID
     */
    @JSONField(serialize = false)
    private Long createUserId;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private Date createTime;

    /**
     * 最后登录IP login_ip
     **/
    private String loginIp;

    /**
     * 最后登录时间 login_time
     **/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    /**
     * 登录token
     */
    private String token;
    private String jti;

    /**
     * 角色列表
     */
    private List roleList;
    /**
     * 部门列表
     */
    private List deptList;
    /**
     * 赛道列表
     */
    private List proList;

}
