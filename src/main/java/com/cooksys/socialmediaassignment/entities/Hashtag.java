package com.cooksys.socialmediaassignment.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "hashtag")
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;

    private String label;

    @CreationTimestamp
    private Timestamp firstUsed;
    
    @UpdateTimestamp
    private Timestamp lastUsed;

    @ManyToMany(mappedBy = "hashtags")
    private List<Tweet> tweetsWithHashtag = new ArrayList<>();

    public void addTweet(Tweet tweet) {
        this.tweetsWithHashtag.add(tweet);
        tweet.getHashtags().add(this);
    }

    public void removeTweet(Tweet tweet) {
        this.tweetsWithHashtag.remove(tweet);
        tweet.getHashtags().remove(this);
    }

}
