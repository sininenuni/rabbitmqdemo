package com.sininenuni.rabbitmqdemo.demo11;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConfirmConsumer {
    public static final String CONFIRM_QUEUE_NAME = "confirm.queue";
    private static final Logger logger= LoggerFactory.getLogger( ConfirmConsumer.class);
    @RabbitListener(queues = CONFIRM_QUEUE_NAME)
    public void receiveMsg(Message message) {
        String msg = new String( message.getBody() );
        logger.info( "接受到队列 confirm.queue 消息:{}", msg );
    }
}