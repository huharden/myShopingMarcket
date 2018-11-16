package com.muf.shopping.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-15-16:57
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.muf.shopping.admin", "com.muf.shopping.common"})
public class AdminApplication {
    public static void main(String[] args){
        SpringApplication.run(AdminApplication.class,args);
    }
}
