package com.muf.lock.server;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-21-9:41
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
