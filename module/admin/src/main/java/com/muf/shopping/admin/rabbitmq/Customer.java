package com.muf.shopping.admin.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-19-15:05
 */
@RestController
public class Customer {

    public final static String QueueName = "queue_transaction";
    public final static String ExchangeName = "mq-exchange";

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(value = QueueName, durable = "true", exclusive ="false", autoDelete = "false"),
                            exchange = @Exchange(value = "exchange_test", durable = "true")
                    )
            }
    )
    public void getRabbitMqQueue(String message) {
        System.out.println(message+"123");
    }
}
