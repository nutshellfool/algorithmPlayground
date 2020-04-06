package me.lirui.algo.binarysearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

  private BinarySearch mSolution;

  @Before
  public void setUp() {
    mSolution = new BinarySearch();
  }

  @Test
  public void binarySearchStand() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int position = mSolution.binarySearchStandard(array, 5);
    Assert.assertTrue(position != -1);
    Assert.assertEquals(4, position);
  }

  @Test
  public void binarySearchStandFront() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int position = mSolution.binarySearchStandard(array, 1);
    Assert.assertTrue(position != -1);
    Assert.assertEquals(0, position);
  }

  @Test
  public void binarySearchStandEnd() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int position = mSolution.binarySearchStandard(array, 10);
    Assert.assertTrue(position != -1);
    Assert.assertEquals(9, position);
  }

  @Test
  public void binarySearchStandNotExists() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int position = mSolution.binarySearchStandard(array, 11);
    Assert.assertEquals(-1, position);
  }

  @Test
  public void binarySearchLowerBound() {
    int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
    int position = mSolution.binarySearchLowerBound(array, 6);
    Assert.assertEquals(5, position);
  }

  @Test
  public void binarySearchLowerBoundFront() {
    int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
    int position = mSolution.binarySearchLowerBound(array, 1);
    Assert.assertEquals(0, position);
  }

  @Test
  public void binarySearchLowerBoundEnd() {
    int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
    int position = mSolution.binarySearchLowerBound(array, 8);
    Assert.assertEquals(9, position);
  }

  @Test
  public void binarySearchLowerBoundNotExists() {
    int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
    int position = mSolution.binarySearchLowerBound(array, 10);
    Assert.assertEquals(-1, position);
  }
}
