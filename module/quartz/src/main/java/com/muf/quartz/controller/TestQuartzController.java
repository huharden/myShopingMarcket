package com.muf.quartz.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-14-9:18
 */
@Component
public class TestQuartzController {
    int  num = 0;
        @Scheduled(cron = "*/5 * * * * *")
        public void scheduled(){
            num++;
            System.out.print("定时任务启动"+num);
        }
       /* @Scheduled(fixedRate = 5000)
        public void scheduled1() {
            log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
        }
        @Scheduled(fixedDelay = 5000)
        public void scheduled2() {
            log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
        }*/

}
