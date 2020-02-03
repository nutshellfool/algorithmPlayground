package me.lirui.algo.design.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

// LRU Cache
// https://leetcode.com/problems/lru-cache/
public class LRUCache {
  private LinkedHashMap<Integer, Integer> mMap;
  private final int CAPACITY;

  LRUCache(int capacity) {
    CAPACITY = capacity;
    mMap = new LinkedHashMap<Integer, Integer>((int)Math.round(capacity / 0.75), 0.75f, true){
      @Override
      protected boolean removeEldestEntry(Entry eldest) {
        return size() > CAPACITY;
      }
    };
  }

  public int get(int key) {
    return mMap.get(key) == null ? -1 : mMap.get(key);
  }

  void put(int key, int value) {
    mMap.put(key,value);
  }
}
// LRU Cache
// https://leetcode.com/problems/lru-cache/
// End
