package com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id , UserDto userDto);

    void deleteUserById(Long id);

    UserDto getPostsById(Long id);
}
