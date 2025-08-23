package com.email.dispatcher.services.impl;

import com.email.dispatcher.entities.FailedMessageKafka;
import com.email.dispatcher.repositories.FailedMessageKafkaRepository;
import com.email.dispatcher.services.KafkaProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final FailedMessageKafkaRepository failedMessageKafkaRepository;

    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper, FailedMessageKafkaRepository failedMessageKafkaRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.failedMessageKafkaRepository = failedMessageKafkaRepository;
    }

    @Override
    @CircuitBreaker(name = "kafkaProducer", fallbackMethod = "fallbackSend")
    @Retry(name = "kafkaProducer")
    public void sendMessage(String key, Object object, String topic) {
        try {
            String objectJson = objectMapper.writeValueAsString(object);
            this.kafkaTemplate.send(topic, key, objectJson);
            log.info("Sending object: {} to topic: {} and key: {}", objectJson, topic, key);
        } catch (Exception e) {
            log.error("Error during serialization: {}", e.getMessage());
        }
    }

    @Override
    public void fallbackSend(String key, Object object, Throwable throwable) {
        log.error("An error happened while trying to send a message to topic, key: {} with error message: {} ", key, throwable.getMessage());
        try {
            String objectJson = objectMapper.writeValueAsString(object);

            var entity = FailedMessageKafka.builder()
                    .key(key)
                    .message(objectJson)
                    .build();

            failedMessageKafkaRepository.save(entity);

            log.warn("Saving the message {} into database", objectJson);
        } catch (Exception e) {
            log.error("Error while creating a fallback message: {}", e.getMessage());
        }

    }
}
