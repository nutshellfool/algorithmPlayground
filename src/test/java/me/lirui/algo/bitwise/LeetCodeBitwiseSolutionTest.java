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
}
