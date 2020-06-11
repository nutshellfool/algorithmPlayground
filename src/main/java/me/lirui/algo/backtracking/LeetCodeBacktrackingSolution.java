package me.lirui.algo.backtracking;

import java.util.ArrayList;
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

    for (int i = start; i <= n; i++) {
      tempList.add(i);
      _combine(result, tempList, i + 1, n, k);
      tempList.remove(tempList.size() - 1);
    }
  }
}
