package me.lirui.algo.design.newsfeed;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterTest {

  private Twitter mTwitter;

  @Before
  public void setUp() {
    mTwitter = new Twitter();
  }

  @Test
  public void happyCaseTest() {
    mTwitter.postTweet(1, 5);
    List<Integer> feedIds = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feedIds);
    Assert.assertEquals(1, feedIds.size());
    Assert.assertEquals(5, (int) feedIds.get(0));

    mTwitter.follow(1, 2);
    mTwitter.postTweet(2, 6);

    List<Integer> feedIds1 = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feedIds1);
    Assert.assertEquals(2, feedIds1.size());
    Assert.assertEquals(6, (int) feedIds1.get(0));
    Assert.assertEquals(5, (int) feedIds1.get(1));
  }

  @Test
  public void doNothingAndGetFeedIds() {
    List<Integer> feedIds = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feedIds);
    Assert.assertEquals(0, feedIds.size());
  }

  @Test
  public void followeeNoPostCaseTest() {
    mTwitter.follow(1, 3);
    List<Integer> feedIds = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feedIds);
    Assert.assertEquals(0, feedIds.size());
  }

  @Test
  public void feedLengthHappyCase() {
    for (int i = 0; i < 10; i++) {
      mTwitter.postTweet(1, 10 + i);
    }

    List<Integer> feeds = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feeds);
    Assert.assertEquals(10, feeds.size());
  }

  @Test
  public void feedLengthMoreThanBoundaryCase() {
    for (int i = 0; i < 11; i++) {
      mTwitter.postTweet(1, 10 + i);
    }

    List<Integer> feeds = mTwitter.getNewsFeed(1);
    Assert.assertNotNull(feeds);
    Assert.assertEquals(10, feeds.size());
    Assert.assertEquals(20, (int) feeds.get(0));
    Assert.assertEquals(19, (int) feeds.get(1));
  }

  @Test
  public void testUnfollow() {
    mTwitter.postTweet(1, 5);
    mTwitter.follow(1, 3);
    mTwitter.postTweet(3, 6);

    mTwitter.unfollow(1, 3);

    List<Integer> feedIds2 = mTwitter.getNewsFeed(1);

    Assert.assertNotNull(feedIds2);
    Assert.assertEquals(1, feedIds2.size());
    Assert.assertEquals(5, (int) feedIds2.get(0));
  }

  @Test
  public void testUnfollowSelf() {
    mTwitter.postTweet(2, 5);
    mTwitter.unfollow(2, 2);
    List<Integer> feeds = mTwitter.getNewsFeed(2);
    Assert.assertNotNull(feeds);
    Assert.assertEquals(1, feeds.size());
    Assert.assertEquals(5, (int) feeds.get(0));
  }
}