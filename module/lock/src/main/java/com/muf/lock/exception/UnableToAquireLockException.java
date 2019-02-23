package com.muf.lock.exception;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-22-16:45
 */
public class UnableToAquireLockException extends RuntimeException {

    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
