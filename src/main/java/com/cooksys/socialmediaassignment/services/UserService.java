package com.cooksys.socialmediaassignment.services;

import java.util.List;

import com.cooksys.socialmediaassignment.dtos.CredentialsDto;
import com.cooksys.socialmediaassignment.dtos.TweetResponseDto;
import com.cooksys.socialmediaassignment.dtos.UserRequestDto;
import com.cooksys.socialmediaassignment.dtos.UserResponseDto;

public interface UserService {

	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByUsername(String username);

	UserResponseDto createUser(UserRequestDto userRequestDto);

	UserResponseDto deleteUser(CredentialsDto credentialDto, String username);

	UserResponseDto updateUser(UserRequestDto userRequestDto, String username);

	void createFollower(String username, CredentialsDto credentialsDto);

	List<UserResponseDto> getFollowersByUsername(String username);

	List<UserResponseDto> getFollowingByUsername(String username);

	void createUnFollower(String username, CredentialsDto credentialsDto);

	List<TweetResponseDto> getTweetByUsername(String username);

	List<TweetResponseDto> getMentions(String username);

	List<TweetResponseDto> getFeed(String username);
}