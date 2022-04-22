package me.lirui.algo.dynamicprogramming;

public class DynamicProgrammingSolution {

  double factorial(int n) {
    if (n < 0) {
      return -1;
    }
    if (n < 2) {
      return 1;
    }

    double approximation;
    // Stirling's Approximation: N! = Sqrt (2 * PI * N) * (N / e)^N
    // https://en.wikipedia.org/wiki/Stirling%27s_approximation
    approximation = Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
    return Math.ceil(approximation);
  }

  long factorialRecursion(int n) {
    if (n < 0) {
      return -1;
    }
    if (n < 2) {
      return 1;
    }

    return factorialRecursion(n - 1) * n;
  }

  long factorialRecursionWithMemo(int n) {
    if (n < 0) {
      return -1;
    }
    if (n < 2) {
      return 1;
    }
    long[] memo = new long[n + 1];
    if (memo[n] != 0) {
      return memo[n];
    }
    memo[n] = factorialRecursionWithMemo(n - 1) * n;
    return memo[n];
  }

  long factorialDynamicProgramming(int n) {
    if (n < 0) {
      return -1;
    }

    long[] dp = new long[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] * i;
    }

    return dp[n];
  }

}
