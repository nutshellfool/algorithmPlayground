package me.lirui.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeDynamicProgrammingSolutionTest {

  private LeetCodeDynamicProgrammingSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeDynamicProgrammingSolution();
  }

  @Test
  public void fib() {
    int fib = mSolution.fib(2);
    Assert.assertEquals(1, fib);
  }

  @Test
  public void fibZero() {
    int fib = mSolution.fib(0);
    Assert.assertEquals(0, fib);
  }

  @Test
  public void fibBigInt() {
    int fib = mSolution.fib(30);
    Assert.assertEquals(832040, fib);
  }

  @Test
  public void fibRecursion() {
    int fib = mSolution.fibRecursion(2);
    Assert.assertEquals(1, fib);
  }

  @Test
  public void fibRecursionZero() {
    int fib = mSolution.fibRecursion(0);
    Assert.assertEquals(0, fib);
  }

  @Test
  public void fibRecursionBigInt() {
    int fib = mSolution.fibRecursion(30);
    Assert.assertEquals(832040, fib);
  }

  @Test
  public void fibDynamicProgrammingWithNSpace() {
    int fib = mSolution.fibDynamicProgrammingWithNSpace(2);
    Assert.assertEquals(1, fib);
  }

  @Test
  public void fibDynamicProgrammingWithNSpaceZero() {
    int fib = mSolution.fibDynamicProgrammingWithNSpace(0);
    Assert.assertEquals(0, fib);
  }

  @Test
  public void fibDynamicProgrammingWithNSpaceBigInt() {
    int fib = mSolution.fibDynamicProgrammingWithNSpace(30);
    Assert.assertEquals(832040, fib);
  }

  @Test
  public void fibDynamicProgrammingWith1Space() {
    int fib = mSolution.fibDynamicProgrammingWith1Space(2);
    Assert.assertEquals(1, fib);
  }

  @Test
  public void fibDynamicProgrammingWith1SpaceZero() {
    int fib = mSolution.fibDynamicProgrammingWith1Space(0);
    Assert.assertEquals(0, fib);
  }

  @Test
  public void fibDynamicProgrammingWith1SpaceBigInt() {
    int fib = mSolution.fibDynamicProgrammingWith1Space(30);
    Assert.assertEquals(832040, fib);
  }

  @Test
  public void climbStairs() {
    int cs = mSolution.climbStairs(3);
    Assert.assertEquals(3, cs);
  }

  @Test
  public void climbStairsZero() {
    int cs = mSolution.climbStairs(0);
    Assert.assertEquals(0, cs);
  }

  @Test
  public void climbStairsBigInt() {
    int cs = mSolution.climbStairs(30);
    Assert.assertEquals(1346269, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWithNSpace() {
    int cs = mSolution.climbStairsDynamicProgrammingWithNSpace(3);
    Assert.assertEquals(3, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWithNSpaceZero() {
    int cs = mSolution.climbStairsDynamicProgrammingWithNSpace(0);
    Assert.assertEquals(0, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWithNSpaceBigInt() {
    int cs = mSolution.climbStairsDynamicProgrammingWithNSpace(30);
    Assert.assertEquals(1346269, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWit1NSpace() {
    int cs = mSolution.climbStairsDynamicProgrammingWith1Space(3);
    Assert.assertEquals(3, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWith1SpaceZero() {
    int cs = mSolution.climbStairsDynamicProgrammingWith1Space(0);
    Assert.assertEquals(0, cs);
  }

  @Test
  public void climbStairsDynamicProgrammingWith1SpaceBigInt() {
    int cs = mSolution.climbStairsDynamicProgrammingWith1Space(30);
    Assert.assertEquals(1346269, cs);
  }

  @Test
  public void minimumTotal() {
    List<List<Integer>> triangle = new ArrayList<>();
    List<Integer> level0 = new ArrayList<>();
    level0.add(2);
    List<Integer> level1 = new ArrayList<>();
    level1.add(3);
    level1.add(4);
    List<Integer> level2 = new ArrayList<>();
    level2.add(6);
    level2.add(5);
    level2.add(7);
    List<Integer> level3 = new ArrayList<>();
    level3.add(4);
    level3.add(1);
    level3.add(8);
    level3.add(3);
    triangle.add(level0);
    triangle.add(level1);
    triangle.add(level2);
    triangle.add(level3);

    int minPathSum = mSolution.minimumTotal(triangle);
    Assert.assertEquals(11, minPathSum);
  }

  // Maximum Product Subarray
  // https://leetcode.com/problems/maximum-product-subarray/
  @Test
  public void maxProduct() {
    int[] array = {2, 3, -1, 4};
    int max = mSolution.maxProduct(array);
    Assert.assertEquals(6, max);
  }

  @Test
  public void maxProduct1() {
    int[] array = {-2, -3, -1, -4};
    int max = mSolution.maxProduct(array);
    Assert.assertEquals(24, max);
  }

  @Test
  public void maxProduct3() {
    int[] array = {0, 2};
    int max = mSolution.maxProduct(array);
    Assert.assertEquals(2, max);
  }

  @Test
  public void maxProduct4() {
    int[] array = {0, 0};
    int max = mSolution.maxProductStandDP(array);
    Assert.assertEquals(0, max);
  }

  @Test
  public void maxProductStandDP() {
    int[] array = {2, 3, -1, 4};
    int max = mSolution.maxProductStandDP(array);
    Assert.assertEquals(6, max);
  }

  @Test
  public void maxProductStandDP1() {
    int[] array = {-2, -3, -1, -4};
    int max = mSolution.maxProductStandDP(array);
    Assert.assertEquals(24, max);
  }

  @Test
  public void maxProductStandDP3() {
    int[] array = {0, 2};
    int max = mSolution.maxProductStandDP(array);
    Assert.assertEquals(2, max);
  }

  @Test
  public void maxProductStandDP4() {
    int[] array = {0, 0};
    int max = mSolution.maxProductStandDP(array);
    Assert.assertEquals(0, max);
  }
  // Maximum Product Subarray
  // https://leetcode.com/problems/maximum-product-subarray/
  // End

  //  Longest Increasing Subsequence
  // https://leetcode.com/problems/longest-increasing-subsequence/
  @Test
  public void lengthOfLIS() {
    int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
    int lengthLIS = mSolution.lengthOfLIS(array);
    Assert.assertEquals(4, lengthLIS);
  }

  @Test
  public void lengthOfLISDES() {
    int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int lengthLIS = mSolution.lengthOfLIS(array);
    Assert.assertEquals(1, lengthLIS);
  }

  @Test
  public void lengthOfLISSame() {
    int[] array = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    int lengthLIS = mSolution.lengthOfLIS(array);
    Assert.assertEquals(1, lengthLIS);
  }

  @Test
  public void lengthOfLISEmpty() {
    int[] array = {};
    int lengthLIS = mSolution.lengthOfLIS(array);
    Assert.assertEquals(0, lengthLIS);
  }

  @Test
  public void lengthOfLISNull() {
    int lengthLIS = mSolution.lengthOfLIS(null);
    Assert.assertEquals(0, lengthLIS);
  }
  //  Longest Increasing Subsequence
  // https://leetcode.com/problems/longest-increasing-subsequence/
  // End

  // Coin Change
  // https://leetcode.com/problems/coin-change/
  //
  @Test
  public void coinChange() {
    int[] coins = {1, 2, 5};
    int amount = 11;
    int coinCount = mSolution.coinChange(coins, amount);
    Assert.assertEquals(3, coinCount);
  }

  @Test
  public void coinChangeNotAvailable() {
    int[] coins = {2};
    int amount = 3;
    int coinCount = mSolution.coinChange(coins, amount);
    Assert.assertEquals(-1, coinCount);
  }

  @Test
  public void coinChangeInvalidAmount() {
    int[] coins = {2};
    int amount = -1;
    int coinCount = mSolution.coinChange(coins, amount);
    Assert.assertEquals(-2, coinCount);
  }

  @Test
  public void coinChangeEmptyCoins() {
    int[] coins = {};
    int amount = 1;
    int coinCount = mSolution.coinChange(coins, amount);
    Assert.assertEquals(-2, coinCount);
  }

  @Test
  public void coinChangeNullCoins() {
    int amount = 1;
    int coinCount = mSolution.coinChange(null, amount);
    Assert.assertEquals(-2, coinCount);
  }
  // Coin Change
  // https://leetcode.com/problems/coin-change/
  // End

  // Best Time to Buy and Sell Stock
  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  // End
  @Test
  public void maxProfit() {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int maxProfit = mSolution.maxProfit(prices);
    Assert.assertEquals(5, maxProfit);
  }

  @Test
  public void maxProfitNoResult() {
    int[] prices = {7, 6, 5, 4, 3, 1};
    int maxProfit = mSolution.maxProfit(prices);
    Assert.assertEquals(0, maxProfit);
  }

  @Test
  public void maxProfitInstinct() {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int maxProfit = mSolution.maxProfitInstinct(prices);
    Assert.assertEquals(5, maxProfit);
  }

  @Test
  public void maxProfitInstinctNoResult() {
    int[] prices = {7, 6, 5, 4, 3, 1};
    int maxProfit = mSolution.maxProfitInstinct(prices);
    Assert.assertEquals(0, maxProfit);
  }

  @Test
  public void maxProfitOnePass() {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int maxProfit = mSolution.maxProfitOnePass(prices);
    Assert.assertEquals(5, maxProfit);
  }

  @Test
  public void maxProfitOnePassNoResult() {
    int[] prices = {7, 6, 5, 4, 3, 1};
    int maxProfit = mSolution.maxProfitOnePass(prices);
    Assert.assertEquals(0, maxProfit);
  }
  // Best Time to Buy and Sell Stock
  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  // End
}
