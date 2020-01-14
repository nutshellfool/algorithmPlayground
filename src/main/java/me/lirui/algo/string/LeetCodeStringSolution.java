package me.lirui.algo.string;

import java.util.ArrayList;
import java.util.List;

class LeetCodeStringSolution {

  //
  //  Generate Parentheses -
  // https://leetcode.com/problems/generate-parentheses/
  //
  List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    _genParenthesis(0, 0, n, "", result);
    return result;
  }

  private void _genParenthesis(int left, int right, int n, String resultItem, List<String> result) {
    if (left == n && right == n) {
      result.add(resultItem);
      return;
    }

    if (left < n) _genParenthesis(left + 1, right, n, resultItem + "(", result);
    if (left > right && right < n) _genParenthesis(left, right + 1, n, resultItem + ")", result);
  }
  //
  //  Generate Parentheses -
  // https://leetcode.com/problems/generate-parentheses/
  // End
}
