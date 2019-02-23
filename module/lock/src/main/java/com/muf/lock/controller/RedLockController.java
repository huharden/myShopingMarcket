package com.muf.lock.controller;

import com.muf.lock.server.AquiredLockWorker;
import com.muf.lock.server.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-22-17:00
 */
@RestController
@RequestMapping("redLock")
public class RedLockController {
    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("index")
    public String index()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {

            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello world!";
    }
}
