package com.cooksys.socialmediaassignment.mappers;

import org.mapstruct.Mapper;

import com.cooksys.socialmediaassignment.dtos.ProfileDto;
import com.cooksys.socialmediaassignment.entities.embeddable.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	Profile ProfileDtoToEntity(ProfileDto profileDto);

}
