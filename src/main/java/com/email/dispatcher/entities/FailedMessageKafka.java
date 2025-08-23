package com.email.dispatcher.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document("FailedMessageKafka")
public class FailedMessageKafka extends BaseEntity {
    private String key;
    private String message;
    private boolean sent = false;
}
