package com.muf.lock.controller;

import com.muf.lock.entity.Lock;
import com.muf.lock.handler.DistributedLockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-19-16:05
 */
@RequestMapping("/test")
@RestController
public class HelloController {
    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        Lock lock=new Lock("lynn","min");
        if(distributedLockHandler.tryLock(lock)){
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法");
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            distributedLockHandler.releaseLock(lock);
        }
        return "hello world!";
    }

}
