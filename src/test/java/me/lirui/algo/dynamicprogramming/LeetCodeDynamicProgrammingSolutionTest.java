package me.lirui.algo.dynamicprogramming;

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
}
