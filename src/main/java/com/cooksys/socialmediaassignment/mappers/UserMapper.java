package com.cooksys.socialmediaassignment.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.socialmediaassignment.dtos.UserRequestDto;
import com.cooksys.socialmediaassignment.dtos.UserResponseDto;
import com.cooksys.socialmediaassignment.entities.User;

@Mapper(componentModel = "spring", uses = { CredentialsMapper.class, ProfileMapper.class })
public interface UserMapper {

	@Mapping(target = "username", source = "credentials.username")
	UserResponseDto entityToUserResponseDto(User user);

	List<UserResponseDto> entitiesToUserResponseDtos(List<User> users);

	Set<UserResponseDto> entitiesToUserResponseDtos(Set<User> users);

	User userRequestDtoToEntity(UserRequestDto userRequestDto);

}
