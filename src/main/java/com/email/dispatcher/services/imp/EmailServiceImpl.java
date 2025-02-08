package com.email.dispatcher.services.imp;

import com.email.dispatcher.dtos.EmailDTO;
import com.email.dispatcher.exceptions.EmailException;
import com.email.dispatcher.mappers.EmailMapper;
import com.email.dispatcher.repositories.EmailRepository;
import com.email.dispatcher.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    @Override
    @Transactional
    public EmailDTO send(EmailDTO email, List<MultipartFile> files) {
        try {
            var result = emailRepository.save(emailMapper.dtoToEmail(email));

            return emailMapper.emailToDto(result);
        } catch (EmailException error) {
            log.error("An exception occurred trying to send an email: {}", error.getMessage());
        }
        return null;
    }

    @Override
    public Page<EmailDTO> findAll(Pageable pageable) {
        try {
            var result = emailRepository.findAll(pageable);

            return result.map(emailMapper::emailToDto);
        } catch (EmailException e) {
            log.error("The list email is empty");
        }
        return null;
    }
}
