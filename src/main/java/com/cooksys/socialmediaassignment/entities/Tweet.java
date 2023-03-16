package com.cooksys.socialmediaassignment.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"reposts", "repostOf", "hashtags", "author", "usersMentioned", "likes", "replies", "inReplyTo"})
public class Tweet {

	@Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User author;
    
    @CreationTimestamp
    private Timestamp posted; 
    
    private boolean deleted = false; 
    
    private String content;
    
    @ManyToOne
    private Tweet inReplyTo;
    
  
    @OneToMany(mappedBy = "inReplyTo")
    private List<Tweet> replies = new ArrayList<>();
    
    @ManyToOne
    private Tweet repostOf;
    
    @OneToMany(mappedBy = "repostOf")
    private List<Tweet> reposts; 
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
    	name = "tweet_hashtags",
    	joinColumns = @JoinColumn(name = "tweet_id"),
    	inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    	)
    private List<Hashtag> hashtags = new ArrayList<>();
    
    @ManyToMany(mappedBy = "likedTweets")
    private List<User> likedByUsers = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
    	name = "user_mentions",
    	joinColumns = @JoinColumn(name = "tweet_id"),
    	inverseJoinColumns = @JoinColumn(name = "user_id")
    	)
    private List<User> mentions = new ArrayList<>();
    
    
    /*
     * Methods to call in TweetServiceImpl
     */
    public void addMentionedUser(User user) {
        this.mentions.add(user);
        user.getMentions().add(this);
    }

    public void removeMentionedUser(User user) {
        this.mentions.remove(user);
        user.getMentions().remove(this);
    }

    public void addLike(User user) {
        this.likedByUsers.add(user);
        user.getLikedTweets().add(this);
    }

    public void removeLike(User user) {
        this.likedByUsers.add(user);
        user.getLikedTweets().remove(this);
    }

    public void addHashtag(Hashtag hashtag) {
        this.hashtags.add(hashtag);
        hashtag.getTweetsWithHashtag().add(this);
    }

    public void removeHashtag(Hashtag hashtag) {
        this.hashtags.remove(hashtag);
        hashtag.getTweetsWithHashtag().remove(this);
    }
}