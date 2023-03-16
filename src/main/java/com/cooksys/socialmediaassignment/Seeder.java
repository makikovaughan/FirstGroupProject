//package com.cooksys.socialmediaassignment;
//

//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.cooksys.socialmediaassignment.entities.Hashtag;
//import com.cooksys.socialmediaassignment.entities.Tweet;
//import com.cooksys.socialmediaassignment.entities.User;
//import com.cooksys.socialmediaassignment.entities.embeddable.Credentials;

//import com.cooksys.socialmediaassignment.entities.embeddable.Profile;
//import com.cooksys.socialmediaassignment.repositories.HashtagRepository;
//import com.cooksys.socialmediaassignment.repositories.TweetRepository;
//import com.cooksys.socialmediaassignment.repositories.UserRepository;
//

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.cooksys.socialmediaassignment.entities.embeddable.Credentials;
//
//import lombok.RequiredArgsConstructor;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.List;
//

//import lombok.RequiredArgsConstructor;
//

//
//@Component
//@RequiredArgsConstructor
//public class Seeder implements CommandLineRunner {
//
//	private final UserRepository userRepository;
//	private final TweetRepository tweetRepository;
//	private final HashtagRepository hashtagRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Credentials credential1 = new Credentials();
//
//		credential1.setUsername("mboren");
//		credential1.setPassword("password");
//		Profile profile1 = new Profile();
//		profile1.setEmail("mboren@cooksys.com");
//		profile1.setFirstName("Michael");
//		profile1.setLastName("Boren");
//		profile1.setPhone("(901)907-7909");
//
//		User user1 = new User();
//		user1.setCredentials(credential1);
//		user1.setProfile(profile1);
//		user1.setDeleted(false);
//
//		userRepository.saveAndFlush(user1);
//
//		Credentials credential2 = new Credentials();
//		credential2.setUsername("wmarttala");
//		credential2.setPassword("password");
//		Profile profile2 = new Profile();
//		profile2.setEmail("wmarttala@cooksys.com");
//		profile2.setFirstName("Will");
//		profile2.setLastName("Marttala");
//		profile2.setPhone("wmarttala@cooksys.com");
//
//		User user2 = new User();
//		user2.setCredentials(credential2);
//		user2.setProfile(profile2);
//		user2.setDeleted(false);
//		userRepository.saveAndFlush(user2);
//
//		Tweet tweet = new Tweet();
//		tweet.setDeleted(false);
//		tweet.setAuthor(user1.getId());
//		tweet.setContent("Tweet from the first user! @wmarttala #weAreNumber1");
//		List<User> likedBy = new ArrayList<>();
//		likedBy.add(user2);
//        tweet.setLikedByUsers(likedBy);
//		tweet.setPosted(new Timestamp(System.currentTimeMillis()));
//		List<User> mentioned = new ArrayList<>();
//		mentioned.add(user2);
//		tweet.setMentions(mentioned);
//
//		Tweet tweet2 = new Tweet();
//		tweet2.setDeleted(false);
//		tweet2.setAuthor(user2.getId());
//		tweet2.setContent("Tweet from the second user! @mboren #youAreNumber1");
//        List<User> likedBy2 = new ArrayList<>();
//		likedBy2.add(user1);
//		likedBy2.add(user2);
//		tweet2.setLikedByUsers(likedBy2);
//		tweet2.setPosted(new Timestamp(System.currentTimeMillis()));
//		List<User> mentioned2 = new ArrayList<>();
//		mentioned2.add(user1);
//		tweet2.setMentions(mentioned2);
//		tweet2.setInReplyTo(tweet);
//
//		tweetRepository.saveAndFlush(tweet);
//		tweetRepository.saveAndFlush(tweet2);
//
//		//IMPORTANT: saving tweets a second time crashes
//
////		List<Tweet> replies = new ArrayList<>();
//
////		replies.add(tweet);
////		tweet.setReplies(replies);
//
//		Hashtag hashtag = new Hashtag();
//		hashtag.setLabel("weAreNumber1");
//		hashtagRepository.saveAndFlush(hashtag);
//		List<Tweet> tweetsWithHashtag = new ArrayList<>();
//		tweetsWithHashtag.add(tweet);
//		hashtag.setTweetsWithHashtag(tweetsWithHashtag);
//		hashtagRepository.saveAndFlush(hashtag);
//
//		Hashtag hashtag2 = new Hashtag();
//		hashtag2.setLabel("youAreNumber1");
//		hashtagRepository.saveAndFlush(hashtag2);
//		List<Tweet> tweetsWithHashtag2 = new ArrayList<>();
//		tweetsWithHashtag2.add(tweet2);
//		hashtag2.setTweetsWithHashtag(tweetsWithHashtag2);
//		hashtagRepository.saveAndFlush(hashtag2);
//
//        //List<Hashtag> hashtagList = new ArrayList<>();
//		//hashtagList.add(hashtag);
//		//tweet.setHashtags(hashtagList);
////		tweet2.setHashtags(hashtagList);
//
//
//		//tweetRepository.saveAndFlush(tweet);
//		//tweetRepository.saveAndFlush(tweet2);
//
//
//	}
//
//}