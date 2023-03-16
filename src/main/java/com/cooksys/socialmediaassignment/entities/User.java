package com.cooksys.socialmediaassignment.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.cooksys.socialmediaassignment.entities.embeddable.Credentials;
import com.cooksys.socialmediaassignment.entities.embeddable.Profile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp joined;

	@Embedded
	private Credentials credentials;

	@Embedded
	private Profile profile;

	private boolean deleted = false;

	@OneToMany(mappedBy = "author")
	private List<Tweet> tweets;

	@ManyToMany
	@JoinTable(name = "followers_following")
	private List<User> followers;

	@ManyToMany(mappedBy = "followers")
	private List<User> following;


	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "user_likes", joinColumns = { @JoinColumn(name = "tweet_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<Tweet> likedTweets;

	//NOTE: map by on other side than join
	@ManyToMany(mappedBy = "mentions",cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Tweet> mentions;
}
