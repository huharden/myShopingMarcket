package com.muf.quartz.service.impl;

import com.muf.quartz.dao.QuartzTestMapper;
import com.muf.quartz.service.QuartzTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Autor: hutao
 * Date: 2018-11-14-14:37
 */
@Service
public class QuartzTestServiceImpl implements QuartzTestService {

    @Autowired
    private QuartzTestMapper quartzTestMapper;

    @Override
    public String testDemo(){
        return quartzTestMapper.testDemo();

    }
}
