package com.muf.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-14-9:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class quartzApplication {
    public static void main(String[] args){
        SpringApplication.run(quartzApplication.class, args);
    }
}
