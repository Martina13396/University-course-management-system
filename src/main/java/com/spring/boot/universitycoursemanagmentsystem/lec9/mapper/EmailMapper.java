package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmailDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Email;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    EmailMapper EMAIL_MAPPER = Mappers.getMapper(EmailMapper.class);

EmailDto toEmailDto(Email email);
Email toEmail(EmailDto emailDto);

List<Email> toEmail(List<EmailDto> emails);

List<EmailDto> toEmailDto(List<Email> emailDtos);
}
