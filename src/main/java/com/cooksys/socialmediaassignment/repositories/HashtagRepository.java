package com.cooksys.socialmediaassignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmediaassignment.entities.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>{
    Hashtag findByLabel(String label);
}
