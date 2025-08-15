package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec11.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.UserDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service.UserService;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec11.mapper.UserMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.User;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec11.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if(Objects.nonNull(userDto.getId())){
          throw new RuntimeException("id must be null");
        }
        Optional<User> userOptional = userRepo.findByName(userDto.getName());
        if(userOptional.isPresent()){
            throw new RuntimeException("user already exists");
        }
        User user = userMapper.toUser(userDto);
        userRepo.save(user);
        userDto.setId(user.getId());
        return userDto;

    }

    @Override
    public UserDto getUserById(Long id) {
       Optional<User> userOptional = userRepo.findById(id);
       if(!userOptional.isPresent()){
           throw new RuntimeException("user not found");
       }
       return userMapper.toUserDto(userOptional.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        if (CollectionUtils.isEmpty(users)) {
            return new ArrayList<>();
        }
        return users.stream().map(user ->  userMapper.toUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id , UserDto userDto) {

        Optional<User> userOptional = userRepo.findById(id);
        if(!userOptional.isPresent()){
            throw new RuntimeException("user not found");
        }
        if(Objects.isNull(userDto.getId())){
            throw new RuntimeException("id must not be null");
        }
        User user = userMapper.toUser(userDto);
        userRepo.save(user);
        return userDto;



    }

    @Override
    public void deleteUserById(Long id) {

        userRepo.deleteById(id);

    }

    @Override
    public UserDto getPostsById(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(!userOptional.isPresent()){
            throw new RuntimeException("user not found");

        }
        return userMapper.toUserDto(userOptional.get());
    }
}
