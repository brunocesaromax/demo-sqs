package com.bcdev.sqs;

import com.bcdev.sqs.consumer.QueueMessage;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsApplication implements CommandLineRunner {

    @Autowired
    private SqsTemplate sqsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SqsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var QUEUE = "https://localhost.localstack.cloud:4566/000000000000/queue-test";
        sqsTemplate.send(QUEUE, new QueueMessage("start value"));
    }
}
