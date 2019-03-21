package com.muf.lock.server;

import com.muf.lock.exception.UnableToAquireLockException;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-21-11:15
 */
public interface DistributedLocker {
    /**
     * 获取锁
     * @param resourceName  锁的名称
     * @param worker 获取锁后的处理类
     * @param <T>
     * @return 处理完具体的业务逻辑要返回的数据
     * @throws UnableToAquireLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception;

    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception;

}