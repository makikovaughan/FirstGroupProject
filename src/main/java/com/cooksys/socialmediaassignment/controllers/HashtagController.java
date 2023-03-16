package com.cooksys.socialmediaassignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cooksys.socialmediaassignment.dtos.HashtagResponseDto;
import com.cooksys.socialmediaassignment.dtos.TweetResponseDto;
import com.cooksys.socialmediaassignment.services.HashtagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class HashtagController {


    private final HashtagService hashtagService;

    @GetMapping
    public List<HashtagResponseDto> getAllTags() {
        return hashtagService.getAllTags();
    }

    @RequestMapping(value = "/{label}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TweetResponseDto> getTweetsWithTag(@PathVariable("label") String label) {
        return hashtagService.getTweetsWithTag(label);
    }

}
