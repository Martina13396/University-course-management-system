package com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmailDto;

import java.util.List;

public interface EmailService {

    EmailDto createEmail(EmailDto emailDto);

    EmailDto updateEmail(EmailDto emailDto);

    void deleteEmail(Long id);

    List<EmailDto> getAllEmails();

    List<EmailDto> getEmailByName(String emailName);

    List<EmailDto> getEmailByListOfNames(List<String> names);

    EmailDto getEmailByContent(String emailContent);


}
