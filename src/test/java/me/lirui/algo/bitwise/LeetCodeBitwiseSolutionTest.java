package me.lirui.algo.bitwise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeBitwiseSolutionTest {

  private LeetCodeBitwiseSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeBitwiseSolution();
  }

  //  Number of 1 Bits
  //  https://leetcode.com/problems/number-of-1-bits/
  @Test
  public void hammingWeight() {
    int countOf1Bits = mSolution.hammingWeight(4);
    Assert.assertEquals(1, countOf1Bits);
  }

  @Test
  public void hammingWeightZero() {
    int countOf1Bits = mSolution.hammingWeight(0);
    Assert.assertEquals(0, countOf1Bits);
  }

  @Test
  public void hammingWeightIntMax() {
    int countOf1Bits = mSolution.hammingWeight(Integer.MAX_VALUE);
    Assert.assertEquals(31, countOf1Bits);
  }

  @Test
  public void hammingWeightBrutalForce() {
    int countOf1Bits = mSolution.hammingWeightBrutalForce(4);
    Assert.assertEquals(1, countOf1Bits);
  }

  @Test
  public void hammingWeightBrutalForceZero() {
    int countOf1Bits = mSolution.hammingWeightBrutalForce(0);
    Assert.assertEquals(0, countOf1Bits);
  }

  @Test
  public void hammingWeightBrutalForceIntMax() {
    int countOf1Bits = mSolution.hammingWeightBrutalForce(Integer.MAX_VALUE);
    Assert.assertEquals(31, countOf1Bits);
  }
  //  Number of 1 Bits
  //  https://leetcode.com/problems/number-of-1-bits/
  //  End
  //  Power of Two
  //  https://leetcode.com/problems/number-of-1-bits/
  //
  @Test
  public void isPowerOfTwo() {
    boolean isPower = mSolution.isPowerOfTwo(4);
    Assert.assertTrue(isPower);
  }

  @Test
  public void isPowerOfTwoNot() {
    boolean isPower = mSolution.isPowerOfTwo(6);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoZero() {
    boolean isPower = mSolution.isPowerOfTwo(0);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoNegative() {
    boolean isPower = mSolution.isPowerOfTwo(-2);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoIntMax() {
    boolean isPower = mSolution.isPowerOfTwo(Integer.MAX_VALUE);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoBrutalForce() {
    boolean isPower = mSolution.isPowerOfTwoBrutalForce(4);
    Assert.assertTrue(isPower);
  }

  @Test
  public void isPowerOfTwoBrutalForceNot() {
    boolean isPower = mSolution.isPowerOfTwoBrutalForce(6);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoBrutalForceZero() {
    boolean isPower = mSolution.isPowerOfTwoBrutalForce(0);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoBrutalForceNegative() {
    boolean isPower = mSolution.isPowerOfTwoBrutalForce(-2);
    Assert.assertFalse(isPower);
  }

  @Test
  public void isPowerOfTwoBrutalForceIntMax() {
    boolean isPower = mSolution.isPowerOfTwoBrutalForce(Integer.MAX_VALUE);
    Assert.assertFalse(isPower);
  }
  //  Power of Two
  //  https://leetcode.com/problems/number-of-1-bits/
  //  End
}
