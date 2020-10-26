package com.company.kafkawithcuba.service;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.inject.Inject;

@Service(SerderMessageService.NAME)
public class SerderMessageServiceBean implements SerderMessageService {

    @Inject
    private Logger logger;

    @Inject
    private KafkaTemplate<Integer, String> template;

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Override
    public void sendMessage(String message) {
        logger.info("Sending {}", message);
        long id = uniqueNumbersService.getNextNumber("users");
        ListenableFuture<SendResult<Integer, String>> send = template.send("users", (int) id, message);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Failed to send message {}, error {}", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                logger.info("Message {} sent", message);
            }
        });
    }
}