package com.muf.shopping.admin.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-19-15:05
 */
@Component
public class Customer {

    public final static String QueueName = "exchange_test";
    public final static String ExchangeName = "mq-exchange";

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(value = QueueName, durable = "true", exclusive ="false", autoDelete = "false"),
                            exchange = @Exchange(value = ExchangeName, durable = "true")
                    )
            }
    )
    public void getRabbitMqQueue(String message) {
        System.out.println(message);
    }
}
