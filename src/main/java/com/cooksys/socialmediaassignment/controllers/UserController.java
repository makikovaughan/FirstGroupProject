package com.cooksys.socialmediaassignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmediaassignment.dtos.CredentialsDto;
import com.cooksys.socialmediaassignment.dtos.TweetResponseDto;
import com.cooksys.socialmediaassignment.dtos.UserRequestDto;
import com.cooksys.socialmediaassignment.dtos.UserResponseDto;
import com.cooksys.socialmediaassignment.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	// Get all user information
	@GetMapping
	public List<UserResponseDto> getAllUsers() {
		return userService.getAllUsers();
	}

	// Checks whether or not a given username exists.
	@GetMapping("/@{username}")
	public UserResponseDto getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	// Create a new user
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.createUser(userRequestDto);
	}

	// Delete a user
	@DeleteMapping("/@{username}")
	public UserResponseDto deleteUser(@RequestBody CredentialsDto credentialDto, @PathVariable String username) {
		return userService.deleteUser(credentialDto, username);
	}

	// Patch a user
	@PatchMapping("/@{username}")
	public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username) {
		return userService.updateUser(userRequestDto, username);
	}

	// Create follow
	@PostMapping("/@{username}/follow")
	@ResponseStatus(HttpStatus.CREATED)
	public void createFollower(@PathVariable String username, @RequestBody CredentialsDto credentialsDto) {
		userService.createFollower(username, credentialsDto);
	}

	// Unsubscribes the user
	@PostMapping("/@{username}/unfollow")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUnFollower(@PathVariable String username, @RequestBody CredentialsDto credentialsDto) {
		userService.createUnFollower(username, credentialsDto);
	}

	// Get user's follower's information
	@GetMapping("/@{username}/followers")
	public List<UserResponseDto> getFollowersByUsername(@PathVariable String username) {
		return userService.getFollowersByUsername(username);
	}

	// Get user's following information
	@GetMapping("/@{username}/following")
	public List<UserResponseDto> getFollowingByUsername(@PathVariable String username) {
		return userService.getFollowingByUsername(username);
	}

	// Get all tweets for the user
	@GetMapping("/@{username}/tweets")
	public List<TweetResponseDto> getTweetByUsername(@PathVariable String username) {
		return userService.getTweetByUsername(username);
	}


	// Subscribes the user whose credentials are provided by the request body to the
	// user whose username is given in the url.
//	@PostMapping("/@{username}/follow")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void createFollower(@PathVariable String username, @RequestBody CredentialsDto credentialsDto) {
//		userService.createFollower(username, credentialsDto);
//	}

	// Get user's mentions
	@GetMapping("/@{username}/mentions")
	public List<TweetResponseDto> getMentions(@PathVariable String username) {
		return userService.getMentions(username);
	}
	// Get user's mentions
	@GetMapping("/@{username}/feed")
	public List<TweetResponseDto> getFeed(@PathVariable String username) {
		return userService.getFeed(username);
	}
}