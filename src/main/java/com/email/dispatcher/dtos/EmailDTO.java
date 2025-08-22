package com.email.dispatcher.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {
    @NotBlank
    @Email
    private String from;
    @NotBlank
    @Email
    private String to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String message;
    private Long templateId;
}
