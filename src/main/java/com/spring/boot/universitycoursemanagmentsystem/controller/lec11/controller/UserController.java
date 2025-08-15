package com.spring.boot.universitycoursemanagmentsystem.controller.lec11.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.UserDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){

        return ResponseEntity.ok(userService.createUser(userDto));

    }

     @GetMapping("/userWithPost/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @GetMapping("/usersWithPost")
    ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());

    }

     @PutMapping("users/{id}")
    ResponseEntity<UserDto> updateUser(@PathVariable Long id , @RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id,userDto));

    }

    @DeleteMapping("users/{id}")
    ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        if (Objects.nonNull(id)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("users/userWithPost/{id}")
    ResponseEntity<UserDto> getPostsById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getPostsById(id));

    }
}
