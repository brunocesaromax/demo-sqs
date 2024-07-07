package com.bcdev.sqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @SqsListener("queue-test")
    public void listen(QueueMessage msg) {
        System.out.println("Message received" + msg.content());
    }
}
