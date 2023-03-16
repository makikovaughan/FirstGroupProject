package com.cooksys.socialmediaassignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmediaassignment.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByDeletedFalse();

	Optional<User> findUserByCredentialsUsernameAndDeletedFalse(String username);

	Optional<User> findUserByCredentialsUsername(String username);
}