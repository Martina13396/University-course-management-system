package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec9.impl;


import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmailDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service.EmailService;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.EmailMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Email;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec9.repo.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {
    EmailRepo emailRepo;
    EmailMapper emailMapper;

    @Autowired
    public EmailServiceImpl(EmailRepo emailRepo, EmailMapper emailMapper) {
        this.emailRepo = emailRepo;
        this.emailMapper = emailMapper;
    }

    @Override
    public EmailDto createEmail(EmailDto emailDto) {
        if(Objects.nonNull(emailDto.getId())){
            throw new RuntimeException("Email id must be null");
        }
        Optional<Email> emailOptional = emailRepo.findByContent(emailDto.getContent());
        if(emailOptional.isPresent()){
            throw new RuntimeException("Email content must be unique");
        }
        Email email = emailMapper.toEmail(emailDto);
        email = emailRepo.save(email);
        emailDto.setId(email.getId());
        return emailDto;
    }

    @Override
    public EmailDto updateEmail(EmailDto emailDto) {

        if(Objects.isNull(emailDto.getId())){
            throw new RuntimeException("Email id must not be null");
        }
        Email email = emailMapper.toEmail(emailDto);

        email = emailRepo.save(email);

        return emailDto;
    }

    @Override
    public void deleteEmail(Long id) {

        emailRepo.deleteById(id);

    }

    @Override
    public List<EmailDto> getAllEmails() {
        List<Email> emails = emailRepo.findAll();

        if(CollectionUtils.isEmpty(emails)){
            return new ArrayList<>();
        }
      return emails.stream().map(email->emailMapper.toEmailDto(email)).collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailByName(String emailName) {

   Optional<List<Email>> emails =  emailRepo.findByName(emailName);

   if(!emails.isPresent()){
       return new ArrayList<>();
   }
   return emails.get().stream().map(email->emailMapper.toEmailDto(email)).collect(Collectors.toList());



    }

    @Override
    public List<EmailDto> getEmailByListOfNames(List<String> names) {
        Optional<List<Email>> emails =  emailRepo.findByNameIn(names);
        if(!emails.isPresent()){
            return new ArrayList<>();
        }
        return emails.get().stream().map(email->emailMapper.toEmailDto(email)).collect(Collectors.toList());
    }

    @Override
    public EmailDto getEmailByContent(String emailContent) {

        Optional<Email> email = emailRepo.findByContent(emailContent);
        if(!email.isPresent()){
            throw new RuntimeException("Email content not found");
        }
       return emailMapper.toEmailDto(email.get());
    }

}



