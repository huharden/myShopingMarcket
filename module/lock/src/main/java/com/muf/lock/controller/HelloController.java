package com.muf.lock.controller;

import com.muf.lock.entity.Lock;
import com.muf.lock.handler.DistributedLockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.ga.LocaleNames_ga;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-19-16:05
 */
@RequestMapping("/test")
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        Lock lock=new Lock("lynn","min");
        System.out.println(lock);
        if(distributedLockHandler.tryLock(lock)){
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法");
                Thread.sleep(5000);
            }catch (Exception e){
                logger.error("错误信息："+e.getMessage(),e);
            }
            distributedLockHandler.releaseLock(lock);
        }
        return "hello world!";
    }

}
