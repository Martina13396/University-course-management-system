package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec11.mapper;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.UserDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {PostMapper.class})
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<User> toUserList(List<UserDto> userDtos);

    List<UserDto> toUserDtoList(List<User> users);
}
