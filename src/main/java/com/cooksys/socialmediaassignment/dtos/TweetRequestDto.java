package com.cooksys.socialmediaassignment.dtos;

import com.cooksys.socialmediaassignment.entities.embeddable.Credentials;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TweetRequestDto {
    private String content;
    private Credentials credentials;
}
