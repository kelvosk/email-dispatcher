package com.email.dispatcher.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {
    private String id;
    private String from;
    private String to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String message;
    private Long templateId;
}
