package me.lirui.algo.dynamicprogramming;

import java.util.List;

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

  // Climbing Stairs
  // https://leetcode.com/problems/climbing-stairs/
  //
  int minimumTotal(List<List<Integer>> triangle) {
    int lineSize = triangle.size();
    int colMaxSize = triangle.get(lineSize - 1).size();

    int[][] dp = new int[lineSize][colMaxSize];
    for (int k = 0; k < colMaxSize; k++) {
      dp[lineSize - 1][k] = triangle.get(lineSize - 1).get(k);
    }

    for (int i = lineSize - 2; i >= 0; i--) {
      int columnSize = triangle.get(i).size();
      for (int j = 0; j <= columnSize - 1; j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        //        System.out.printf("triangle (%d , %d) = %d \n", i, j, triangle.get(i).get(j));
        //        System.out.printf("dp[%d][%d] = %d \n", i, j, dp[i][j]);
      }
    }

    return dp[0][0];
  }
  // Climbing Stairs
  // https://leetcode.com/problems/climbing-stairs/
  // End

  // Maximum Product Subarray
  // https://leetcode.com/problems/maximum-product-subarray/
  int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return -1;

    int[] dpPositive = new int[nums.length];
    int[] dpNegative = new int[nums.length];
    dpNegative[0] = nums[0];
    dpPositive[0] = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dpPositive[i] =
          Math.max(Math.max(dpPositive[i - 1] * nums[i], dpNegative[i - 1] * nums[i]), nums[i]);
      dpNegative[i] =
          Math.min(Math.min(dpPositive[i - 1] * nums[i], dpNegative[i - 1] * nums[i]), nums[i]);
      result = Math.max(result, dpPositive[i]);
    }

    return result;
  }
  // Maximum Product Subarray
  // https://leetcode.com/problems/maximum-product-subarray/
  // End

  //  Longest Increasing Subsequence
  // https://leetcode.com/problems/longest-increasing-subsequence/
  int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int result = 1;
    int[] dp = new int[nums.length];
    int length = nums.length;
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
    }
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      result = Math.max(result, dp[i]);
    }

    return result;
  }
  //  Longest Increasing Subsequence
  // https://leetcode.com/problems/longest-increasing-subsequence/
  // End
}
