package com.email.dispatcher.repositories;

import com.email.dispatcher.entities.FailedMessageKafka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailedMessageKafkaRepository extends MongoRepository<FailedMessageKafka, String> {
}
