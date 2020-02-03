package me.lirui.algo.design.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

  private LRUCache mLRUCache;

  @Before
  public void setUp() {
    mLRUCache = new LRUCache(2);
    mLRUCache.put(1, 1);
    mLRUCache.put(2, 2);
  }

  @Test
  public void get() {
    int cachedValue = mLRUCache.get(1);
    Assert.assertEquals(1, cachedValue);
  }

  @Test
  public void put() {
    mLRUCache.put(3, 3);
    int cachedValue = mLRUCache.get(1);
    // [3, 2]
    Assert.assertEquals(-1, cachedValue);
    mLRUCache.put(4, 4);
    // [4, 3]
    int value1 = mLRUCache.get(3);
    Assert.assertEquals(3, value1);
    int value2 = mLRUCache.get(2);
    Assert.assertEquals(-1, value2);
    int value3 = mLRUCache.get(4);
    Assert.assertEquals(4, value3);
  }
}