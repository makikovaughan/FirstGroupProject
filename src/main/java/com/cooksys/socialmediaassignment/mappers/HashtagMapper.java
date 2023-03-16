package com.cooksys.socialmediaassignment.mappers;


import com.cooksys.socialmediaassignment.dtos.HashtagResponseDto;
import com.cooksys.socialmediaassignment.entities.Hashtag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
    HashtagResponseDto entityToDto(Hashtag entity);

    List<HashtagResponseDto> entitiesToDtos(List<Hashtag> entities);

    List<Hashtag> DtosToentities(List<HashtagResponseDto> dtos);
}
