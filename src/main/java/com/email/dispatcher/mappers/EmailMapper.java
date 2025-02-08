package com.email.dispatcher.mappers;

import com.email.dispatcher.dtos.EmailDTO;
import com.email.dispatcher.entities.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    Email dtoToEmail(EmailDTO dto);
    EmailDTO emailToDto(Email email);
}
