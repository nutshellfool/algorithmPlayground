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
    int position = mSolution.binarySearchStand(array, 5);
    Assert.assertTrue(position != -1);
    Assert.assertEquals(4, position);
  }
}
