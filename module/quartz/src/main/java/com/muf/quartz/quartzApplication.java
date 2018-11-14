package com.muf.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-14-9:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@ComponentScan(basePackages = "com.muf.quartz")
public class quartzApplication {
    public static void main(String[] args){
        SpringApplication.run(quartzApplication.class, args);
    }
}
