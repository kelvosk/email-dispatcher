package com.email.dispatcher.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document("email")
public class Email extends BaseEntity {
    private String from;
    private String to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String message;
    private Long templateId;
}
