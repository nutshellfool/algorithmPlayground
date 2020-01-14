package me.lirui.algo.binarysearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeBinarySearchSolutionTest {

  private LeetCodeBinarySearchSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeBinarySearchSolution();
  }

  @Test
  public void mySqrt() {
    int sqr = mSolution.mySqrt(4);
    Assert.assertEquals(2, sqr);
  }

  @Test
  public void mySqrtRound() {
    int sqr = mSolution.mySqrt(8);
    Assert.assertEquals(2, sqr);
  }

  @Test
  public void mySqrtBigInt() {
    int sqr = mSolution.mySqrt(2147395599);
    Assert.assertEquals(46339, sqr);
  }

  @Test
  public void mySqrtInvalid() {
    int sqr = mSolution.mySqrt(-1);
    Assert.assertEquals(-1, sqr);
  }
}
