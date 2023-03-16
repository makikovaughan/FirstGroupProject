package com.cooksys.socialmediaassignment.dtos;

import java.sql.Timestamp;

import com.cooksys.socialmediaassignment.entities.Tweet;

import com.cooksys.socialmediaassignment.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TweetResponseDto {

    private Long id;
    private UserResponseDto author;
    private String content;
    private Timestamp posted;
    private TweetResponseDto inReplyTo;
    private TweetResponseDto repostOf;
}
