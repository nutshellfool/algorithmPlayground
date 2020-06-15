package me.lirui.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
