package me.lirui.algo.design.newsfeed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

// Design Twitter
// https://leetcode.com/problems/design-twitter/

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
class Twitter {

  private static final int NUMBER_OF_TWEET_LIMIT = 10;

  // Actually, this implementation is a "pull on demand" mode,
  // "push on change" mode is another topic.
  //

  private HashMap<Integer, ArrayList<Tweet>> userTweetListMap;
  private HashMap<Integer, Set<Integer>> userFollowMap;
  private int timeSequence;

  /**
   * Initialize your data structure here.
   */
  Twitter() {
    userTweetListMap = new HashMap<>();
    userFollowMap = new HashMap<>();
    timeSequence = 0;
  }

  /**
   * Compose a new tweet.
   */
  void postTweet(int userId, int tweetId) {
    ArrayList<Tweet> tweetList = userTweetListMap.get(userId);
    if (tweetList == null) {
      tweetList = new ArrayList<>();
      userTweetListMap.put(userId, tweetList);
      // follow himself first
      follow(userId, userId);
    }

    tweetList.add(new Tweet(tweetId, timeSequence++));

  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  List<Integer> getNewsFeed(int userId) {
    Set<Integer> followList = userFollowMap.get(userId);
    if (followList == null) {
      return new ArrayList<>();
    }

    PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(followList.size(),
        new Comparator<Tweet>() {
          @Override
          public int compare(Tweet o1, Tweet o2) {
            return o2.timeElapsed - o1.timeElapsed;
          }
        });

    for (int followerId : followList) {
      List<Tweet> tweets = userTweetListMap.get(followerId);
      // Here is a test case
      if (tweets == null) {
        continue;
      }

      for (Tweet tweet : tweets) {
        maxHeap.offer(tweet);
      }
    }

    List<Integer> newsFeeds = new ArrayList<>(maxHeap.size());
    while (newsFeeds.size() < NUMBER_OF_TWEET_LIMIT && !maxHeap.isEmpty()) {
      newsFeeds.add(maxHeap.poll().tweetId);
    }

    return newsFeeds;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  void follow(int followerId, int followeeId) {
    Set<Integer> followList = userFollowMap.get(followerId);
    if (followList == null) {
      followList = new TreeSet<>();
      userFollowMap.put(followerId, followList);
    }
    followList.add(followeeId);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  void unfollow(int followerId, int followeeId) {
    Set<Integer> followList = userFollowMap.get(followerId);
    // user can not unfollow himself
    if (followList != null && followerId != followeeId) {
      followList.remove(followeeId);
    }
  }

  class Tweet {

    int tweetId;
    int timeElapsed;

    Tweet(int tweetId, int timeElapsed) {
      this.tweetId = tweetId;
      this.timeElapsed = timeElapsed;
    }
  }
}
// Design Twitter
// https://leetcode.com/problems/design-twitter/
// End