package com.email.dispatcher.services;

import com.email.dispatcher.dtos.EmailDTO;
import com.email.dispatcher.entities.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmailService {

    EmailDTO send(EmailDTO email, List<MultipartFile> files);
    Page<Email> findAll(Pageable pageable);
}
