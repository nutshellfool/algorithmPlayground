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

    if (left < n) {
      _genParenthesis(left + 1, right, n, resultItem + "(", result);
    }
    if (left > right && right < n) {
      _genParenthesis(left, right + 1, n, resultItem + ")", result);
    }
  }
  //
  //  Generate Parentheses -
  // https://leetcode.com/problems/generate-parentheses/
  // End

  int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0) {
      return 0;
    }

    if (haystack == null || haystack.length() == 0) {
      return -1;
    }

    // String Knuth-Morris-Pratt algorithm
    int[] lps = computeKMPTable(needle);
    int i = 0, j = 0, n = haystack.length(), m = needle.length();
    while (i < n) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        ++i;
        ++j;
        if (j == m) {
          return i - m;
        }
      } else {
        if (j != 0) {
          j = lps[j - 1]; // try match with longest prefix suffix
        } else {
          i++; // don't match -> go to next character of `haystack` string
        }
      }
    }
    return -1;
  }

  private int[] computeKMPTable(String pattern) {
    int i = 1, j = 0, n = pattern.length();
    int[] lps = new int[n];
    while (i < n) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        lps[i++] = ++j;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return lps;
  }

  int strStrInstinct(String haystack, String needle) {
    if (needle == null || needle.length() == 0) {
      return 0;
    }

    if (haystack == null || haystack.length() == 0) {
      return -1;
    }

    return haystack.indexOf(needle);
  }
}
