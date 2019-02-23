package com.muf.lock.controller;

import com.muf.lock.server.AquiredLockWorker;
import com.muf.lock.server.DistributedLocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(RedLockController.class);
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
                    logger.error(e.getMessage(), e);
                }
                return null;
            }

        });
        return "hello world!";
    }
}
