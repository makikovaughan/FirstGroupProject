package com.cooksys.socialmediaassignment.repositories;

import java.util.List;

import com.cooksys.socialmediaassignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmediaassignment.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
	

	List<Tweet> findAllByAuthorAndDeletedFalseOrderByPostedDesc(User user);


}