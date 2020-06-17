package me.lirui.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeetCodeBacktrackingSolution {

  List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> templist = new ArrayList<>();
    _combine(resultList, templist, 1, n, k);
    return resultList;
  }

  private void _combine(List<List<Integer>> result, List<Integer> tempList, int start, int n,
      int k) {
    if (tempList.size() == k) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = start; i <= n - (k - tempList.size()) + 1; i++) {
      tempList.add(i);
      _combine(result, tempList, i + 1, n, k);
      tempList.remove(tempList.size() - 1);
    }
  }

  List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> steps = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    _subsets(nums, 0, steps, result);
    return result;
  }

  private void _subsets(int[] nums, int start, List<Integer> steps, List<List<Integer>> result) {
    result.add(new ArrayList<>(steps));
    for (int i = start; i < nums.length; i++) {
      steps.add(nums[i]);
      _subsets(nums, i + 1, steps, result);
      steps.remove(steps.size() - 1);
    }
  }

  List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);

    List<Integer> steps = new ArrayList<>();
    List<List<Integer>> resultSet = new ArrayList<>();
    _subsetWithDup(nums, 0, steps, resultSet);
    return new ArrayList<>(resultSet);
  }

  private void _subsetWithDup(int[] nums, int start, List<Integer> steps,
      List<List<Integer>> result) {
    result.add(new ArrayList<>(steps));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }

      steps.add(nums[i]);
      _subsetWithDup(nums, i + 1, steps, result);
      steps.remove(steps.size() - 1);
    }
  }

  List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() == 0 || s.length() > 12) {
      return new ArrayList<>();
    }

    List<String> result = new ArrayList<>();
    _restoreIpAddress(s, 0, 4, "", result);

    return result;
  }

  private void _restoreIpAddress(String s, int start, int leftPartCount, String digitalPart,
      List<String> result) {
    if (leftPartCount == 0 && start == s.length()) {
      //
      result.add(digitalPart.substring(0, digitalPart.length() - 1));
      return;
    }

    for (int i = 1; i < 4; i++) {
      if (s.length() - start >= i) {
        String segment = s.substring(start, start + i);
        if (isValid(segment)) {
          _restoreIpAddress(s, start + i,
              leftPartCount - 1, digitalPart + segment + ".", result);
        }
      }
    }
  }

  private boolean isValid(String segment) {
    if (segment.length() == 0 || (segment.length() > 1 && segment.charAt(0) == '0')) {
      return false;
    }
    int intVal = Integer.parseInt(segment);
    return intVal >= 0 && intVal <= 255;
  }

  boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (_exist(board, i, j, word, 0, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  private static final int[] DX = {0, 1, 0, -1};
  private static final int[] DY = {1, 0, -1, 0};


  private boolean _exist(char[][] board, int i, int j, String word, int wordCharIndex,
      boolean[][] visited) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }

    if (visited[i][j] || board[i][j] != word.charAt(wordCharIndex)) {
      return false;
    }

    if (wordCharIndex == word.length() - 1) {
      return true;
    }

    visited[i][j] = true;
    boolean exist = false;
    for (int directionIndex = 0; directionIndex < 4; directionIndex++) {
      exist |= _exist(board, i + DX[directionIndex], j + DY[directionIndex], word,
          wordCharIndex + 1, visited);
    }
    if (!exist) {
      visited[i][j] = false;
    }
    return exist;
  }

  List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    Map<String, String> phone = new HashMap<String, String>() {{
      put("2", "abc");
      put("3", "def");
      put("4", "ghi");
      put("5", "jkl");
      put("6", "mno");
      put("7", "pqrs");
      put("8", "tuv");
      put("9", "wxyz");
    }};
    List<String> result = new ArrayList<>();
    backtrack("", digits, phone, result);
    return result;
  }


  private void backtrack(String combination, String next_digits, Map<String, String> phoneMap,
      List<String> result) {
    if (next_digits.length() == 0) {
      result.add(combination);
      return;
    }
    String digit = next_digits.substring(0, 1);
    String letters = phoneMap.get(digit);
    for (int i = 0; i < letters.length(); i++) {
      String letter = phoneMap.get(digit).substring(i, i + 1);
      backtrack(combination + letter, next_digits.substring(1), phoneMap, result);
    }
  }

  List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(candidates);
    List<Integer> steps = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    _combinationSum(candidates, 0, target, steps, result);
    return result;
  }

  private void _combinationSum(int[] candidates, int start, int remain, List<Integer> steps,
      List<List<Integer>> result) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<>(steps));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      steps.add(candidates[i]);
      _combinationSum(candidates, i, remain - candidates[i], steps, result);
      steps.remove(steps.size() - 1);
    }
  }
}
