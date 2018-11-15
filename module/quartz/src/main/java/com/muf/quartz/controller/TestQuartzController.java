package com.muf.quartz.controller;

import com.muf.quartz.dao.QuartzTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-14-9:18
 */
@Component
public class TestQuartzController {
    @Autowired
    private QuartzTestMapper quartzTestMapper;

    int  num = 0;
        @Scheduled(cron = "*/5 * * * * *")
        public void scheduled(){
            num++;
            System.out.print("定时任务启动"+num);
            String subjectId = quartzTestMapper.testDemo();
            System.out.print("定时任务启动"+subjectId);
        }




}
