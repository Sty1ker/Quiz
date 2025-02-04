package com.example.quiz.web.mappers;

import com.example.quiz.domain.user.User;
import com.example.quiz.web.dto.userDto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
