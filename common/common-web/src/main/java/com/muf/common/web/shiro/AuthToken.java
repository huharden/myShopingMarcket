package com.muf.common.web.shiro;

import com.muf.common.web.model.UserDetails;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.Set;

/**
 * description:
 * @author: hutao
 * @date 2018/11/15 10:23
 */
@Data
public class AuthToken extends UserDetails implements AuthenticationToken {

    public AuthToken(Long userId, String userName, String jwt) {
        super.setUserName(userName);
        super.setUserId(userId);
        super.setJwt(jwt);
    }

    public AuthToken(Long userId, String userName, String jwt, Set<Long> deptSet, Set<String> roleSet, Set<String> permSet) {
        super.setUserName(userName);
        super.setUserId(userId);
        super.setJwt(jwt);
        super.setDeptSet(deptSet);
        super.setRoleSet(roleSet);
        super.setPermSet(permSet);
    }

    @Override
    public Object getPrincipal() {
        return getUserName();
    }

    @Override
    public Object getCredentials() {
        return getJwt();
    }
}
