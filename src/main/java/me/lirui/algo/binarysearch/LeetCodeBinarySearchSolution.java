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
    if (x < 0) {
      return -1;
    }
    if (x == 0 || x == 1) {
      return x;
    }

    int left = 0;
    int right = x;
    int result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid == x / mid) {
        return mid;
      } else if (mid > x / mid) {
        right = mid - 1;
      } else {
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
    if (x < 0) {
      return -1;
    }
    if (x == 0 || x == 1) {
      return x;
    }

    float left = 0, right = x;
    while (left <= right) {
      float mid = left + (right - left) / 2;
      if (Math.abs(mid - x / mid) < epsilon) {
        return mid;
      } else if (mid < x / mid) {
        left = mid;
      } else {
        right = mid;
      }
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
    if (x < 0) {
      return -1;
    }
    if (x == 0 || x == 1) {
      return x;
    }

    int result = x;
    while (result > x / result) {
      result = (result + x / result) / 2;
    }

    return result;
  }

  float sqrtNewton(int x, double epsilon) {
    if (x < 0) {
      return Float.NaN;
    }
    if (x == 0 || x == 1) {
      return x;
    }

    float iterativeResult = x;
    while (Math.abs(iterativeResult - x / iterativeResult) > epsilon / iterativeResult) {
      iterativeResult = (x / iterativeResult + iterativeResult) / 2;
    }
    return iterativeResult;
  }
  //
  //  int Sqrt(x, precision)
  // End

  //  Divide Two Integers
  //  https://leetcode.com/problems/divide-two-integers/
  //
  //  public int divide(int dividend, int divisor) {
  //    if (divisor == 0) throw new RuntimeException("divided by zero");
  //    if (dividend == 0 || divisor == 1) return dividend;
  //
  //    int left = 0;
  //    int right = dividend;
  //    int result = 0;
  //
  //    while (left <= right) {
  //      int mid = left + (right - left) / 2;
  //      if (_multiOp(mid, divisor) == dividend) return mid;
  //      else if (_multiOp(mid, divisor) > dividend) right = mid - 1;
  //      else {
  //        left = mid + 1;
  //        result = mid;
  //      }
  //    }
  //
  //    return result;
  //  }
  //
  //  private int _multiOp(int base, int times) {
  //    int result = 0;
  //    for (int i = 0; i < times; i ++) {
  //      result += base;
  //    }
  //
  //    return result;
  //  }

  int divide(int dividend, int divisor) {
    if (divisor == 0) {
      throw new RuntimeException("divided by zero");
    }
    if (dividend == 0 || divisor == 1) {
      return dividend;
    }
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      throw new RuntimeException("integer overflow");
    }

    // Actually, I think above result make reasonable
    // because Integer.MIN_VALUE = -2 ^ 31 and Integer.MAX_VALUE = 2^31 - 1
    // so the real result should be Integer.MAX_VALUE + 1 NOT Integer.MAX_VALUE.
    // but in LeetCode testcase, the below code is correct one.
    //
    // An Suggestion Here:
    //    under interview situation, this case should negotiation with interviewer.

    //    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

    boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
    long dividendLongAbs = Math.abs((long) dividend);
    long divisorLongAbs = Math.abs((long) divisor);
    int result = 0;

    while (dividendLongAbs >= divisorLongAbs) {
      int shift = 0;
      while (dividendLongAbs >= divisorLongAbs << shift) {
        shift++;
      }
      dividendLongAbs = dividendLongAbs - (divisorLongAbs << (shift - 1));
      result = result + (1 << (shift - 1));
    }

    return isNeg ? -result : result;
  }
  //  Divide Two Integers
  //  https://leetcode.com/problems/divide-two-integers/
  // End

  //  Pow(x, n)
  //  https://leetcode.com/problems/powx-n/
  double myPow(double x, int n) {
    return _myPow(x, n);
  }

  private double _myPow(double x, long n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      n = -n;
      x = 1.0 / x;
    }

    double powResult = 1.0;
    while (n > 0) {
      if (n % 2 == 1) {
        powResult *= x;
      }
      x *= x;
      n /= 2;
    }

    return powResult;
  }

  double myPowRecursion(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return myPowRecursion(1.0 / x, -n);
    }

    return myPowRecursion(x * x, n / 2);
  }

  double myPowBrutalForce(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      n = -n;
      x = 1.0 / x;
    }

    double result = 1;
    if (n > 0) {
      for (int i = 1; i <= n; i++) {
        result *= x;
      }
    }

    return result;
  }
  //  Pow(x, n)
  //  https://leetcode.com/problems/powx-n/
  //  End
}
