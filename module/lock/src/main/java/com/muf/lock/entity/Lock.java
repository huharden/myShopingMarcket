package com.muf.lock.entity;

import lombok.Data;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-19-16:00
 */
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
