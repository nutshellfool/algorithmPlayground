package me.lirui.algo.binarysearch;

class LeetCodeBinarySearchSolution {
  //
  //  Sqrt(x)
  // https://leetcode.com/problems/sqrtx/
  //
  int mySqrt(int x) {
    return (int) _mySqrt(x);
  }

  private long _mySqrt(long x) {
    if (x < 0) return -1;

    long left = 0, right = x;
    long result = 0;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid * mid == x) return mid;
      if (mid * mid < x) {
        left = mid + 1;
        result = mid;
      }
      if (mid * mid > x) right = mid - 1;
    }

    return result;
  }
  //
  //  Sqrt(x)
  // https://leetcode.com/problems/sqrtx/
  // End
}
