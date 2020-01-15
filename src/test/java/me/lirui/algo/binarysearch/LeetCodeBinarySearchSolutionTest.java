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
  public void mySqrtZero() {
    int sqr = mSolution.mySqrt(0);
    Assert.assertEquals(0, sqr);
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

  @Test
  public void mSqrt() {
    float sqr = mSolution.mSqrt(4, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 2) <= 0.00001);
  }

  @Test
  public void mSqrtRound() {
    float sqr = mSolution.mSqrt(8, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 2.82843) <= 0.00001);
  }

  @Test
  public void mSqrtZero() {
    float sqr = mSolution.mSqrt(0, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 0) <= 0.00001);
  }

  @Test
  public void mSqrtBigInt() {
    float sqr = mSolution.mSqrt(2147395599, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 46340.00000) <= 0.00001);
  }

  @Test
  public void mSqrtInvalid() {
    float sqr = mSolution.mSqrt(-1, 0.00001);
    Assert.assertTrue(Math.abs(sqr + 1.0) < 0.00001);
  }

  @Test
  public void myNewtonSqrt() {
    int sqr = mSolution.sqrtNewton(4);
    Assert.assertEquals(2, sqr);
  }

  @Test
  public void myNewtonSqrtRound() {
    int sqr = mSolution.sqrtNewton(8);
    Assert.assertEquals(2, sqr);
  }

  @Test
  public void myNewtonSqrtZero() {
    int sqr = mSolution.sqrtNewton(0);
    Assert.assertEquals(0, sqr);
  }

  @Test
  public void myNewtonSqrtBigInt() {
    int sqr = mSolution.sqrtNewton(2147395599);
    Assert.assertEquals(46339, sqr);
  }

  @Test
  public void myNewtonSqrtInvalid() {
    int sqr = mSolution.sqrtNewton(-1);
    Assert.assertEquals(-1, sqr);
  }

  @Test
  public void myNewtonSqrtFrag() {
    float sqr = mSolution.sqrtNewton(4, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 2) <= 0.00001);
  }

  @Test
  public void myNewtonSqrtFragRound() {
    float sqr = mSolution.sqrtNewton(8, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 2.82843) <= 0.00001);
//    Assert.assertEquals(2, sqr);
  }

  @Test
  public void myNewtonSqrtFragZero() {
    float sqr = mSolution.sqrtNewton(0, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 0) <= 0.00001);
//    Assert.assertEquals(2, sqr);
  }

  @Test
  public void myNewtonSqrtFragBigInt() {
    float sqr = mSolution.sqrtNewton(2147395599, 0.00001);
    Assert.assertTrue(Math.abs(sqr - 46340.00000) <= 0.00001);
  }

  @Test
  public void myNewtonSqrtFragInvalid() {
    float sqr = mSolution.sqrtNewton(-1, 0.00001);
    Assert.assertEquals(Float.NaN, sqr);
  }
}
