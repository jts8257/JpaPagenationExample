package com.example.postmantest.mapper;

import com.example.postmantest.domain.User;
import com.example.postmantest.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User>{
}
