package me.lirui.algo.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LeetCodeHashMapSolution {

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

  //
  //  Two Sum - https://leetcode.com/problems/two-sum/
  //
  int[] twoSum(int[] nums, int target) {
    if (nums == null) return null;

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = nums.length;
    for (int i = 0; i < count; i++) {
      if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i) {
        return new int[] {i, map.get(target - nums[i])};
      }

      map.put(nums[i], i);
    }

    return null;
  }

  int[] twoSumInBrutalForceWay(int[] nums, int target) {
    if (nums == null) return null;

    int count = nums.length;
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < count; j++) {
        if (nums[i] + nums[j] == target && i != j) {
          return new int[] {i, j};
        }
      }
    }

    return null;
  }
  //
  //  Two Sum - https://leetcode.com/problems/two-sum/
  //  End

  //
  //  3Sum - https://leetcode.com/problems/3sum/
  //
  List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int length = nums.length;
    for (int i = 0; i < length - 1; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int a = nums[i];
      int left = i + 1;
      int right = length - 1;

      while (left < right) {
        int sum = a + nums[left] + nums[right];
        if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        } else {
          ArrayList<Integer> resultItem = new ArrayList<>(3);
          resultItem.add(a);
          resultItem.add(nums[left]);
          resultItem.add(nums[right]);
          result.add(resultItem);
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          left++;
          right--;
        }
      }
    }

    return result;
  }

  List<List<Integer>> threeSumWithMap(int[] nums) {
    if (nums == null || nums.length < 3) return new ArrayList<>();

    Arrays.sort(nums);
    int length = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      map.put(nums[i], i);
    }

    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (map.containsKey(0 - nums[i] - nums[j])
            && (map.get(-nums[i] - nums[j]) != i)
            && (map.get(-nums[i] - nums[j]) != j)) {
          if (nums[i] <= nums[j] && nums[j] <= (-nums[i] - nums[j])) {
            ArrayList<Integer> resultItem = new ArrayList<>(3);
            resultItem.add(nums[i]);
            resultItem.add(nums[j]);
            resultItem.add(-nums[i] - nums[j]);
            result.add(resultItem);
          }
        }
      }
    }

    return new ArrayList<>(result);
  }

  List<List<Integer>> threeSumInBrutalForceWay(int[] nums) {
    if (nums == null || nums.length < 3) return null;

    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        for (int k = j + 1; k < length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            ArrayList<Integer> resultItem = new ArrayList<>(3);
            resultItem.add(nums[i]);
            resultItem.add(nums[j]);
            resultItem.add(nums[k]);
            result.add(resultItem);
          }
        }
      }
    }

    return new ArrayList<>(result);
  }
  //
  //  3Sum - https://leetcode.com/problems/3sum/
  //  End
}
