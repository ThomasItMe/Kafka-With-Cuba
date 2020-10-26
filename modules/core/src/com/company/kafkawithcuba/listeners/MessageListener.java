package com.company.kafkawithcuba.listeners;

import com.company.kafkawithcuba.entity.MessageKafka;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(MessageListener.NAME)
public class MessageListener {
    public static final String NAME = "kafkawithcuba_MessageListener";

    @Inject
    private Logger logger;

    @Inject
    private DataManager dataManager;

    @KafkaListener(id = "kafka-with-cuba", topics = "users")
    public void listenOne(String foo, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) int id) {
        logger.info("Received: {}:{}", id, foo);
        MessageKafka messageKafka = dataManager.create(MessageKafka.class);
        messageKafka.setStt(id);
        messageKafka.setComment(foo);
        dataManager.commit(messageKafka);
        logger.info("Save: {}:{}", id, foo);
    }
}