package me.lirui.algo.binarysearch;

class LeetCodeBinarySearchSolution {
  //
  //  Sqrt(x)
  // https://leetcode.com/problems/sqrtx/
  //

  // ======================================================
  // When integer overflow occurred?
  //
  // some mathematical operation may cause the overflow,  such as the "+" and "*"
  // big integer number will cause the overflow.
  //
  //
  // How to deal with the integer overflow?
  //
  //    the following tricks to deal with the possible int overflow,
  //
  //    1. level up the current parameter to next range level
  //        for example int           -->   long
  //    2. substitute the possible overflow equation with other one
  //        mid = (left + right) / 2  -->   mid = left + (right - left) / 2
  //        mif * mid == x            -->   mid == x / mid

  //
  // Level up trick: (the following code also pass the test cases)
  // ---------------
  //
  //  int mySqrt(int x) {
  //    return (int) _mySqrt(x);
  //  }
  //
  //  private long _mySqrt(long x) {
  //    if (x < 0) return -1;
  //
  //    long left = 0, right = x;
  //    long result = 0;
  //    while (left <= right) {
  //      long mid = left + ((right - left) >> 1);
  //      if (mid * mid == x) return mid;
  //      if (mid * mid < x) {
  //        left = mid + 1;
  //        result = mid;
  //      }
  //      if (mid * mid > x) right = mid - 1;
  //    }
  //
  //    return result;
  //  }
  //

  //
  // mathematical substitution trick:
  // ---------------

  int mySqrt(int x) {
    if (x < 0) return -1;
    if (x == 0 || x == 1) return x;
    int left = 0;
    int right = x;
    int result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid == x / mid) return mid;
      else if (mid > x / mid) right = mid - 1;
      else {
        left = mid + 1;
        result = mid;
      }
    }

    return result;
  }

  //
  //  Sqrt(x, precision)
  // https://leetcode.com/problems/sqrtx/
  // End

  //
  //  float Sqrt(x, epsilon)
  //
  float mSqrt(int x, double epsilon) {
    if (x < 0) return -1;
    if (x == 0 || x == 1) return x;

    float left = 0, right = x;
    while (left <= right) {
      float mid = left + (right - left) / 2;
      if (Math.abs(mid - x / mid) < epsilon) return mid;
      if (mid < x / mid) left = mid;
      if (mid > x / mid) right = mid;
    }

    return Float.NEGATIVE_INFINITY;
  }

  /**
   * Using isaac newton iterative method (Mathematical way) to compute the square root for given
   * target number.
   *
   * <p>In computing mathematics(precisely speaking: numerical analysis): isaac newton iterative
   * method:
   *
   * <p>$x_{n + 1} = x_n - \frac{f(x_n)}{f^\prime (x_n)}$
   *
   * @param x the target number
   * @return the square root of the target number
   */
  int sqrtNewton(int x) {
    if (x < 0) return -1;
    if (x == 0 || x == 1) return x;
    int result = x;
    while (result > x / result) {
      result = (result + x / result) / 2;
    }

    return result;
  }

  float sqrtNewton(int x, double epsilon) {
    if (x < 0) return Float.NaN;
    if (x == 0 || x == 1) return x;

    float iterativeResult = x;
    while (Math.abs(iterativeResult - x / iterativeResult) > epsilon / iterativeResult) {
      iterativeResult = (x / iterativeResult + iterativeResult) / 2;
    }
    return iterativeResult;
  }
  //
  //  int Sqrt(x, precision)
  // End
}
