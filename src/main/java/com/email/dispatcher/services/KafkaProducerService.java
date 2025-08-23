package com.email.dispatcher.services;

public interface KafkaProducerService {
    void sendMessage(String key, Object object, String topic);
    void fallbackSend(String key, Object object, Throwable throwable);
}
