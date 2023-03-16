package com.cooksys.socialmediaassignment.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cooksys.socialmediaassignment.dtos.ErrorDto;
import com.cooksys.socialmediaassignment.exceptions.NotFoundException;
import com.cooksys.socialmediaassignment.exceptions.BadRequestException;
import com.cooksys.socialmediaassignment.exceptions.UnauthorizedException;

import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice(basePackages = { "com.cooksys.socialmediaassignment.controllers" })
@ResponseBody
public class TweetControllerAdvice {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ErrorDto handleBadRequestException(HttpServletRequest request, UnauthorizedException unauthorizedException) {
        return new ErrorDto(unauthorizedException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleBadRequestException(HttpServletRequest request, NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }
}
