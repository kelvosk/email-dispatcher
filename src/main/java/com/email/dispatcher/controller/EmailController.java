package com.email.dispatcher.controller;

import com.email.dispatcher.dtos.EmailDTO;
import com.email.dispatcher.services.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/emails")
public class EmailController {

    private final EmailService emailService;


    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmailDTO> send(@RequestPart("body") EmailDTO email,
                                         @RequestPart(name = "files", required = false) List<MultipartFile> files) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emailService.send(email, files));
    }

    @GetMapping
    public ResponseEntity<Page<EmailDTO>> listEmails(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "5") int size) {

        return ResponseEntity.ok(emailService.findAll(PageRequest.of(page, size)));
    }
}
