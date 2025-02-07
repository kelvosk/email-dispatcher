package com.email.dispatcher.services.imp;

import com.email.dispatcher.dtos.EmailDTO;
import com.email.dispatcher.entities.Email;
import com.email.dispatcher.services.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public EmailDTO send(EmailDTO email, List<MultipartFile> files) {
        return null;
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return null;
    }
}
