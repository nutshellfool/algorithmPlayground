package me.lirui.algo.dynamicprogramming;

class LeetCodeDynamicProgrammingSolution {
  // Fibonacci Number
  // https://leetcode.com/problems/fibonacci-number/
  int fib(int N) {
    double goldRatio = (1 + Math.sqrt(5)) / 2;
    double otherRatio = (1 - Math.sqrt(5)) / 2;

    return (int) Math.round((Math.pow(goldRatio, N) - Math.pow(otherRatio, N)) / Math.sqrt(5));
  }

  int fibRecursion(int N) {
    return N == 0 ? 0 : N < 3 ? 1 : fibRecursion(N - 1) + fibRecursion(N - 2);
  }

  int fibDynamicProgrammingWithNSpace(int N) {
    if (N <= 0) {
      return 0;
    }

    if (N < 3) {
      return 1;
    }

    int[] dp = new int[N + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[N];
  }

  int fibDynamicProgrammingWith1Space(int N) {
    if (N <= 0) {
      return 0;
    }

    if (N < 3) {
      return 1;
    }

    int first = 1;
    int second = 1;
    for (int i = 3; i <= N; i++) {
      //
      int third = first + second;
      first = second;
      second = third;
    }

    return second;
  }
  // Fibonacci Number
  // https://leetcode.com/problems/fibonacci-number/
  // End

  // Climbing Stairs
  // https://leetcode.com/problems/climbing-stairs/
  int climbStairs(int n) {
    if (n <= 0) {
      return 0;
    }

    double goldRatio = (1 + Math.sqrt(5)) / 2;
    double otherRatio = (1 - Math.sqrt(5)) / 2;

    return (int)
        Math.round((Math.pow(goldRatio, n + 1) - Math.pow(otherRatio, n + 1)) / Math.sqrt(5));
  }

  int climbStairsDynamicProgrammingWithNSpace(int n) {
    if (n < 0) {
      return 0;
    }
    if (n < 3) {
      return n;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      //
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  int climbStairsDynamicProgrammingWith1Space(int n) {
    if (n < 0) {
      return 0;
    }
    if (n < 3) {
      return n;
    }

    int first = 1;
    int second = 2;

    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }

    return second;
  }
  // Climbing Stairs
  // https://leetcode.com/problems/climbing-stairs/
  // End
}
