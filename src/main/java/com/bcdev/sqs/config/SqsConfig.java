package com.bcdev.sqs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class SqsConfig {

    private final String LOCALSTACK_LOCALHOST = "http://localhost:4566";

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .endpointOverride(URI.create(LOCALSTACK_LOCALHOST))
                .region(Region.SA_EAST_1)
                .build();
    }
}
