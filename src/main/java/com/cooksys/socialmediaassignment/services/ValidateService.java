package com.cooksys.socialmediaassignment.services;

import com.cooksys.socialmediaassignment.dtos.HashtagResponseDto;

public interface ValidateService {

	boolean checkUserByUsername(String username);

	boolean checkUsernameAvailability(String username);

	boolean validateTagExists(String label);
}
