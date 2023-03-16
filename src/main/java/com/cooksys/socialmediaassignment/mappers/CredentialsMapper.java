package com.cooksys.socialmediaassignment.mappers;

import org.mapstruct.Mapper;

import com.cooksys.socialmediaassignment.dtos.CredentialsDto;
import com.cooksys.socialmediaassignment.entities.embeddable.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {

	Credentials credentialsDtoToEntity(CredentialsDto credentialsDto);

}
