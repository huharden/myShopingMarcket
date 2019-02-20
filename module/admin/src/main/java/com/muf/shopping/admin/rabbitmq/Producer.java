package com.muf.shopping.admin.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muf.shopping.admin.constant.RabbitConstant;
import com.muf.shopping.common.base.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-19-14:41
 */

@RestController
@RequestMapping("/rabbitMq")
public class Producer {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final ConfigurableApplicationContext context;
    private final AmqpTemplate amqpTemplate;

    public Producer(ConfigurableApplicationContext context,
                     AmqpTemplate amqpTemplate) {
        this.context = context;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping(value = "/send")
    public Map<String, Object> send(String args){
        //com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        JSONObject json = new JSONObject();

        json.put("displayName", args);
        //推送到队列
        try {
            amqpTemplate.convertAndSend("mq-exchange", RabbitConstant.SYS_USER_QUEUE_NAME, json.toJSONString());
        } catch (Exception e) {
            logger.error("["+ args +"]推送到im队列失败" + e.getMessage());
        }
        return R.ok("displayName");
    }

}
