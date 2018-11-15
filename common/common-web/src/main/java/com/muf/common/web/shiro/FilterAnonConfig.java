package com.muf.common.web.shiro;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * @author: hutao
 * @date 2018/11/15 10:23
 */
@Data
@Configuration
@ConditionalOnExpression("!'${shiro.anon}'.isEmpty()")
@ConfigurationProperties(prefix = "shiro.anon")
public class FilterAnonConfig {
    private List<String> path = new ArrayList<String>();
}
