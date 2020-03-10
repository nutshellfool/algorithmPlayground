package me.lirui.algo.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeArraySolutionTest {

  private LeetCodeArraySolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeArraySolution();
  }

  @Test
  public void maxAreaInBrutalForceWayHappyCase() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int maxArea = mSolution.maxAreaInBrutalForceWay(height);
    Assert.assertEquals(49, maxArea);
  }

  @Test
  public void maxAreaInBrutalForceWayNullInput() {
    int maxArea = mSolution.maxAreaInBrutalForceWay(null);
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaInBrutalForceWayEmptyInput() {
    int maxArea = mSolution.maxAreaInBrutalForceWay(new int[]{});
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaInBrutalForceWayInputLengthLessThan2() {
    int[] height = {1};
    int maxArea = mSolution.maxAreaInBrutalForceWay(height);
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaInBrutalForceWayInputLengthEqual2() {
    int[] height = {5, 10};
    int maxArea = mSolution.maxAreaInBrutalForceWay(height);
    Assert.assertEquals(5, maxArea);
  }

  @Test
  public void maxAreaHappyCase() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int maxArea = mSolution.maxArea(height);
    Assert.assertEquals(49, maxArea);
  }

  @Test
  public void maxAreaNullInput() {
    int maxArea = mSolution.maxArea(null);
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaEmptyInput() {
    int maxArea = mSolution.maxArea(new int[]{});
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaInputLengthLessThan2() {
    int[] height = {1};
    int maxArea = mSolution.maxArea(height);
    Assert.assertEquals(0, maxArea);
  }

  @Test
  public void maxAreaInputLengthEqual2() {
    int[] height = {5, 10};
    int maxArea = mSolution.maxArea(height);
    Assert.assertEquals(5, maxArea);
  }
}