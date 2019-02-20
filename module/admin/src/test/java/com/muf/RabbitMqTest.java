package com.muf;

import com.muf.shopping.admin.rabbitmq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-19-15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private Producer producer;

    @Test
    public void rabbitMqTest(){
        producer.send("aaa");
    }



}
