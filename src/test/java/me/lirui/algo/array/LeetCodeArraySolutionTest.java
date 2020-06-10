package me.lirui.algo.array;

import java.util.Arrays;
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

  @Test
  public void trapInBrutalForceWayHappyCase() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int unitOfTrappedWater = mSolution.trapInBrutalForceWay(height);
    Assert.assertEquals(6, unitOfTrappedWater);
  }

  @Test
  public void trapInBrutalForceNullInput() {
    int unitOfTrappedWater = mSolution.trapInBrutalForceWay(null);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapInBrutalForceEmptyInput() {
    int unitOfTrappedWater = mSolution.trapInBrutalForceWay(new int[]{});
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapInBrutalForceInputLengthLessThan3() {
    int[] height = {1, 2};
    int unitOfTrappedWater = mSolution.trapInBrutalForceWay(height);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapInBrutalForceInputEqual3() {
    int[] height = {2, 0, 2};
    int unitOfTrappedWater = mSolution.trapInBrutalForceWay(height);
    Assert.assertEquals(2, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionHappyCase() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(height);
    Assert.assertEquals(6, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionHappyCase1() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 3};
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(height);
    Assert.assertEquals(9, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionNullInput() {
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(null);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionEmptyInput() {
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(new int[]{});
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionInputLengthLessThan3() {
    int[] height = {1, 2};
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(height);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapDynamicProgrammingSolutionInputEqual3() {
    int[] height = {2, 0, 2};
    int unitOfTrappedWater = mSolution.trapDynamicProgrammingSolution(height);
    Assert.assertEquals(2, unitOfTrappedWater);
  }

  @Test
  public void trapHappyCase() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int unitOfTrappedWater = mSolution.trap(height);
    Assert.assertEquals(6, unitOfTrappedWater);
  }

  @Test
  public void trapNullInput() {
    int unitOfTrappedWater = mSolution.trap(null);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapEmptyInput() {
    int unitOfTrappedWater = mSolution.trap(new int[]{});
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapInputLengthLessThan3() {
    int[] height = {1, 2};
    int unitOfTrappedWater = mSolution.trap(height);
    Assert.assertEquals(0, unitOfTrappedWater);
  }

  @Test
  public void trapInputEqual3() {
    int[] height = {2, 0, 2};
    int unitOfTrappedWater = mSolution.trap(height);
    Assert.assertEquals(2, unitOfTrappedWater);
  }

  @Test
  public void sortColor() {
    int[] colorArray = {2, 0, 2, 1, 1, 0};
    mSolution.sortColors(colorArray);
    Assert.assertNotNull(colorArray);
    Assert.assertEquals(6, colorArray.length);
    Assert.assertTrue(Arrays.equals(new int[]{0, 0, 1, 1, 2, 2}, colorArray));
  }

  @Test
  public void sortColorEmpty() {
    int[] colorArray = {};
    mSolution.sortColors(colorArray);
    Assert.assertNotNull(colorArray);
    Assert.assertEquals(0, colorArray.length);
    Assert.assertTrue(Arrays.equals(new int[]{}, colorArray));
  }

  @Test
  public void sortColorInstinct() {
    int[] colorArray = {2, 0, 2, 1, 1, 0};
    mSolution.sortColorsInstinct(colorArray);
    Assert.assertNotNull(colorArray);
    Assert.assertEquals(6, colorArray.length);
    Assert.assertTrue(Arrays.equals(new int[]{0, 0, 1, 1, 2, 2}, colorArray));
  }

  @Test
  public void sortColorInstinctEmpty() {
    int[] colorArray = {};
    mSolution.sortColorsInstinct(colorArray);
    Assert.assertNotNull(colorArray);
    Assert.assertEquals(0, colorArray.length);
    Assert.assertTrue(Arrays.equals(new int[]{}, colorArray));
  }

  @Test
  public void moveZeroes() {
    int[] array = {0, 1, 0, 3, 12};
    mSolution.moveZeroes(array);
    Assert.assertNotNull(array);
    Assert.assertEquals(5, array.length);
    Assert.assertTrue(Arrays.equals(new int[]{1, 3, 12, 0, 0}, array));
  }

  @Test
  public void moveZeroes1() {
    int[] array = {0, 3, 0, 1, 12};
    mSolution.moveZeroes(array);
    Assert.assertNotNull(array);
    Assert.assertEquals(5, array.length);
    Assert.assertTrue(Arrays.equals(new int[]{3, 1, 12, 0, 0}, array));
  }

}