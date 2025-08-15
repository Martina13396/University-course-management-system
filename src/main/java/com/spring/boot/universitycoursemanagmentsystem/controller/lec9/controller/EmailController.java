package com.spring.boot.universitycoursemanagmentsystem.controller.lec9.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmailDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class EmailController {

    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("create-email")
    ResponseEntity<EmailDto>createEmail(@RequestBody @Valid EmailDto emailDto){

        return ResponseEntity.ok(emailService.createEmail(emailDto));

    }

    @PutMapping("update-email")
    ResponseEntity<EmailDto> updateEmail(@RequestBody @Valid EmailDto emailDto){
        return ResponseEntity.ok(emailService.updateEmail(emailDto));

    }

    @DeleteMapping("delete-email")
    ResponseEntity<Void> deleteEmail(Long id){

        if (Objects.nonNull(id)) {
            return ResponseEntity.noContent().build();
        }
            else{
                return ResponseEntity.notFound().build();
            }
        }

     @GetMapping("all-emails")
    ResponseEntity<List<EmailDto>> getAllEmails() {
    return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("emails-byName/{emailName}")
    ResponseEntity<List<EmailDto>> getEmailByName(@PathVariable String emailName){
        return ResponseEntity.ok(emailService.getEmailByName(emailName));
    }

    @GetMapping("emails-byNames/{names}")
    ResponseEntity<List<EmailDto>> getEmailByListOfNames(@PathVariable List<String> names){
        return ResponseEntity.ok(emailService.getEmailByListOfNames(names));

    }

    @GetMapping("email-byContent/{emailContent}")
    ResponseEntity<EmailDto> getEmailByContent(@PathVariable String emailContent){
        return ResponseEntity.ok(emailService.getEmailByContent(emailContent));
    }

}
