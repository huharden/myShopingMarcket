package com.muf.common.web.model;


import lombok.Data;

import java.util.Set;

/**
 * description: 
 * @author: hutao
 * @date 2018/11/15 10:26 
 */
@Data
public class UserDetails {
    private String userName;
    private Long userId;
    private String jwt;
    private Set<Long> deptSet;
    private Set<String> roleSet;
    private Set<String> proSet;
    private Set<String> permSet;

    public UserDetails() {

    }

    public UserDetails(String userName, Long userId, String jwt, Set<String> roleSet, Set<String> permSet) {
        this.userName = userName;
        this.userId = userId;
        this.jwt = jwt;
        this.roleSet = roleSet;
        this.permSet = permSet;
    }
}
