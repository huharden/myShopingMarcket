package com.muf.shopping.admin.config;

import com.muf.shopping.admin.constant.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-19-16:24
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 声明队列
     *
     * @return
     */
    @Bean
    public Queue queueTransaction() {
        // true表示持久化该队列
        return new Queue(RabbitConstant.QUEUE_TRANSACTION, true);
    }

    @Bean
    public Queue queueContract() {
        // true表示持久化该队列
        return new Queue(RabbitConstant.QUEUE_CONTRACT, true);
    }

    @Bean
    public Queue queueQualification() {
        // true表示持久化该队列
        return new Queue(RabbitConstant.QUEUE_QUALIFICATION, true);
    }

    /**
     * 声明交互器
     *
     * @return
     */
   /* @Bean
    DirectExchange directExchange() {
        return new DirectExchange(RabbitConstant.EXCHANGE);
    }*/
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(RabbitConstant.SYS_USER_QUEUE_NAME);
    }

    /**
     * 绑定
     *
     * @return
     */
    @Bean
    public Binding bindingTransaction(Queue queueTransaction, TopicExchange exchange) {
        return BindingBuilder.bind(queueTransaction).to(exchange).with(RabbitConstant.RK_TRANSACTION);
    }

    /**
     * 绑定
     *
     * @return
     */
    @Bean
    public Binding bindingQueueContract(Queue queueContract, TopicExchange exchange) {
        return BindingBuilder.bind(queueContract).to(exchange).with(RabbitConstant.QUEUE_CONTRACT);
    }

    /**
     * 绑定
     *
     * @return
     */
    @Bean
    public Binding bindingQueueQualification(Queue queueQualification, TopicExchange exchange) {
        return BindingBuilder.bind(queueQualification).to(exchange).with(RabbitConstant.QUEUE_QUALIFICATION);
    }

}
