package com.email.dispatcher.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    private String name;
    private String originalNameFile;
    private String mimeType;
    private String path;
    private LocalDateTime createdAt;
}
