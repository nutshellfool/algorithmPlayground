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
    if (nums == null || nums.length == 0) {
      return -1;
    }

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

  int maxProductStandDP(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int rowLen = nums.length;
    int columnLen = 2;
    int[][] dp = new int[rowLen][columnLen];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int result = nums[0];

    for (int i = 1; i < rowLen; i++) {
      if (nums[i] >= 0) {
        dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
        dp[i][1] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
      } else {
        dp[i][0] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
        dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
      }
      result = Math.max(dp[i][0], result);
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
  // Coin Change
  // https://leetcode.com/problems/coin-change/
  //
  int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 0) {
      return -2;
    }

    int[] dp = new int[amount + 1];
    for (int i = 0; i < amount + 1; i++) {
      dp[i] = amount + 1;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      //
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  // Coin Change
  // https://leetcode.com/problems/coin-change/
  // End
  // Best Time to Buy and Sell Stock
  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  // End
  int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int res = 0;
    int[][] mp = new int[prices.length][3];
    mp[0][0] = 0;
    mp[0][1] = -prices[0];
    mp[0][2] = 0;

    for (int i = 1; i < prices.length; i++) {
      mp[i][0] = mp[i - 1][0];
      mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i]);
      mp[i][2] = mp[i - 1][1] + prices[i];
      res = Math.max(res, Math.max(mp[i][0], Math.max(mp[i][1], mp[i][2])));
    }

    return res;
  }

  int maxProfitInstinct(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        maxProfit = Math.max(maxProfit, (prices[j] - prices[i]));
      }
    }
    return maxProfit;
  }

  int maxProfitOnePass(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      }

      maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
  }

  // Best Time to Buy and Sell Stock
  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  // End
  int maxProfitUnlimitedTransaction(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int[][] maxProfit = new int[prices.length][2];
    maxProfit[0][0] = 0;
    maxProfit[0][1] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      maxProfit[i][0] = Math.max(maxProfit[i - 1][1] + prices[i], maxProfit[i - 1][0]);
      maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i - 1][0] - prices[i]);
    }

    return maxProfit[prices.length - 1][0];
  }

  int maxProfitUnlimitedTransactionOnePass(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        maxProfit += prices[i + 1] - prices[i];
      }
    }
    return maxProfit;
  }

  int maxProfit2limitedTransaction(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    final int MAX_TRANSACTION_NUM = 2;
    int[][][] maxProfit = new int[prices.length][2][MAX_TRANSACTION_NUM + 1];
    for (int k = 0; k < MAX_TRANSACTION_NUM + 1; k++) {
      maxProfit[0][0][k] = 0;
      maxProfit[0][1][k] = -prices[0];
    }

    for (int i = 1; i < prices.length; i++) {
      for (int k = 1; k < MAX_TRANSACTION_NUM + 1; k++) {
        maxProfit[i][0][k] = Math.max(maxProfit[i - 1][0][k], maxProfit[i - 1][1][k] + prices[i]);
        maxProfit[i][1][k] = Math
            .max(maxProfit[i - 1][1][k], maxProfit[i - 1][0][k - 1] - prices[i]);
      }
    }

    int maxProfitResult = 0;
    for (int k = 0; k < MAX_TRANSACTION_NUM + 1; k++) {
      maxProfitResult = Math.max(maxProfitResult, maxProfit[prices.length - 1][0][k]);
    }

    return maxProfitResult;
  }

}
