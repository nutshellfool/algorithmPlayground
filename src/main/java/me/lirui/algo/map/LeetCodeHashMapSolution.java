package me.lirui.algo.map;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeHashMapSolution {

  //
  //  Valid Anagram - https://leetcode.com/problems/valid-anagram/
  //
  boolean isAnagramFinal(String s, String t) {
    if ((s == null && t != null) || (s != null && t == null)) return false;
    if (s == null & t == null) return true;
    if (s.length() != t.length()) return false;

    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    for (int wordCount : counter) {
      if (wordCount != 0) return false;
    }

    return true;
  }

  boolean isAnagram(String s, String t) {

    if ((s == null && t != null) || (s != null && t == null)) return false;
    if (s == null & t == null) return true;
    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> sWordMap = new HashMap<>();
    HashMap<Character, Integer> tWordMap = new HashMap<>();

    char[] sCharArray = s.toCharArray();
    char[] tCharArray = t.toCharArray();

    calculateWordFrequency(sCharArray, sWordMap);
    calculateWordFrequency(tCharArray, tWordMap);

    return sWordMap.equals(tWordMap);
  }

  boolean isAnagramSort(String s, String t) {
    if ((s == null && t != null) || (s != null && t == null)) return false;
    if (s == null & t == null) return true;
    if (s.length() != t.length()) return false;

    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);

    return Arrays.equals(sArray, tArray);
  }

  private void calculateWordFrequency(char[] wordArray, HashMap<Character, Integer> resultMap) {
    for (char ch : wordArray) {
      if (resultMap.get(ch) == null) {
        resultMap.put(ch, 1);
      } else {
        int wordFrequency = resultMap.get(ch);
        resultMap.put(ch, wordFrequency + 1);
      }
    }
  }

  //
  //  Valid Anagram - https://leetcode.com/problems/valid-anagram/
  //  End
  //

}