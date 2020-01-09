package me.lirui.algo.heap;

import me.lirui.algo.heap.LeetCodePriorityQueueSolution.KthLargest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodePriorityQueueSolutionTest {

  private LeetCodePriorityQueueSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodePriorityQueueSolution();
  }

  //
  //  Kth Largest Element in a Stream -
  // https://leetcode.com/problems/kth-largest-element-in-a-stream/
  //
  @Test
  public void testKthLargest() {
    int[] array = new int[] {4, 5, 8, 2};
    KthLargest kthLargest = mSolution.new KthLargest(2, array);

    int kthLargest1 = kthLargest.add(3);
    // 8, 5
    Assert.assertEquals(5, kthLargest1);
    int kthLargest2 = kthLargest.add(5);
    // 8, 5
    Assert.assertEquals(5, kthLargest2);
    int kthLargest3 = kthLargest.add(10);
    // 10, 8
    Assert.assertEquals(8, kthLargest3);
  }
  //
  //  Kth Largest Element in a Stream -
  // https://leetcode.com/problems/kth-largest-element-in-a-stream/
  // End

  //
  //  Kth Largest Element in an Array -
  // https://leetcode.com/problems/kth-largest-element-in-an-array/
  //
  @Test
  public void findKthLargest() {
    int[] array = {3, 2, 1, 5, 6, 4};

    int secondLargest = mSolution.findKthLargest(array, 2);
    Assert.assertEquals(5, secondLargest);
  }

  @Test
  public void findKthLargestDuplicated() {
    int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};

    int fourthLargest = mSolution.findKthLargest(array, 4);
    Assert.assertEquals(4, fourthLargest);
  }

  @Test
  public void findKthLargestNull() {
    int result = mSolution.findKthLargest(null, 4);
    Assert.assertEquals(Integer.MIN_VALUE, result);
  }

  @Test
  public void findKthLargestInvalidK() {
    int[] array = {3, 2, 1, 5, 6, 4};

    int result = mSolution.findKthLargest(array, 7);
    Assert.assertEquals(Integer.MIN_VALUE, result);
  }

  @Test
  public void findKthLargestInvalidKBoundary() {
    int[] array = {3, 2, 1, 5, 6, 4};

    int result = mSolution.findKthLargest(array, 6);
    Assert.assertEquals(1, result);
  }
  //
  //  Kth Largest Element in an Array -
  // https://leetcode.com/problems/kth-largest-element-in-an-array/
  // End

}
