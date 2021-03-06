package me.lirui.algo.heap;

import java.util.Arrays;
import me.lirui.algo.heap.LeetCodePriorityQueueSolution.KthLargest;
import me.lirui.algo.heap.LeetCodePriorityQueueSolution.MedianFinder;
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
    int[] array = new int[]{4, 5, 8, 2};
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

  //
  //  Sliding Window Maximum -
  // https://leetcode.com/problems/sliding-window-maximum/
  //
  @Test
  public void maxSlidingWindow() {
    int[] expect = {3, 3, 5, 5, 6, 7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowHeap(array, 3);
    Assert.assertNotNull(result);
    Assert.assertEquals(6, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowExtremeBoundaryCase() {
    int[] expect = {1, -1};
    int[] array = {1, -1};
    int[] result = mSolution.maxSlidingWindowHeap(array, 1);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowBoundaryCase() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowHeap(array, 8);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowNull() {
    int[] result = mSolution.maxSlidingWindowHeap(null, 0);
    Assert.assertNull(result);
  }

  @Test
  public void maxSlidingWindowEmpty() {
    int[] array = new int[]{};
    int[] result = mSolution.maxSlidingWindowHeap(array, 0);
    Assert.assertTrue(Arrays.equals(array, result));
  }

  @Test
  public void maxSlidingWindowKSizeOverFlow() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowHeap(array, 9);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowBrutalForce() {
    int[] expect = {3, 3, 5, 5, 6, 7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowBrutalForce(array, 3);
    Assert.assertNotNull(result);
    Assert.assertEquals(6, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowBrutalForceExtremeBoundaryCase() {
    int[] expect = {1, -1};
    int[] array = {1, -1};
    int[] result = mSolution.maxSlidingWindowBrutalForce(array, 1);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowBrutalForceBoundaryCase() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowBrutalForce(array, 8);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowBrutalForceNull() {
    int[] result = mSolution.maxSlidingWindowBrutalForce(null, 0);
    Assert.assertNull(result);
  }

  @Test
  public void maxSlidingWindowBrutalForceEmpty() {
    int[] array = new int[]{};
    int[] result = mSolution.maxSlidingWindowBrutalForce(array, 0);
    Assert.assertTrue(Arrays.equals(array, result));
  }

  @Test
  public void maxSlidingWindowKBrutalForceSizeOverFlow() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowBrutalForce(array, 9);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowDeque() {
    int[] expect = {3, 3, 5, 5, 6, 7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowDeque(array, 3);
    Assert.assertNotNull(result);
    Assert.assertEquals(6, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowDeque1() {
    int[] expect = {7, 4};
    int[] array = {7, 2, 4};
    int[] result = mSolution.maxSlidingWindowDeque(array, 2);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowDequeExtremeBoundaryCase() {
    int[] expect = {1, -1};
    int[] array = {1, -1};
    int[] result = mSolution.maxSlidingWindowDeque(array, 1);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowDequeBoundaryCase() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowDeque(array, 8);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void maxSlidingWindowDequeNull() {
    int[] result = mSolution.maxSlidingWindowDeque(null, 0);
    Assert.assertNull(result);
  }

  @Test
  public void maxSlidingWindowDequeEmpty() {
    int[] array = new int[]{};
    int[] result = mSolution.maxSlidingWindowDeque(array, 0);
    Assert.assertTrue(Arrays.equals(array, result));
  }

  @Test
  public void maxSlidingWindowDequeKSizeOverFlow() {
    int[] expect = {7};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = mSolution.maxSlidingWindowDeque(array, 9);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }
  //
  //  Sliding Window Maximum -
  // https://leetcode.com/problems/sliding-window-maximum/
  // End

  //
  //  Sliding Window Median -
  // https://leetcode.com/problems/sliding-window-median/
  //
  @Test
  public void medianSlidingWindow() {
    double[] expect = {1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    double[] result = mSolution.medianSlidingWindow(array, 3);
    Assert.assertNotNull(result);
    Assert.assertEquals(6, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void medianSlidingWindowExtremeBoundaryCase() {
    double[] expect = {1, -1};
    int[] array = {1, -1};
    double[] result = mSolution.medianSlidingWindow(array, 1);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void medianSlidingWindowBoundaryCase() {
    double[] expect = {3};
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    double[] result = mSolution.medianSlidingWindow(array, 8);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void medianSlidingWindowBoundaryCaseEven() {
    double[] expect = {2.5};
    int[] array = {1, 4, 2, 3};
    double[] result = mSolution.medianSlidingWindow(array, 4);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void medianSlidingWindowBoundaryCaseLargeElement() {
    double[] expect = {2147483647.0};
    int[] array = {2147483647, 2147483647};
    double[] result = mSolution.medianSlidingWindow(array, 2);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.length);
    Assert.assertTrue(Arrays.equals(expect, result));
  }

  @Test
  public void medianSlidingWindowNull() {
    double[] result = mSolution.medianSlidingWindow(null, 0);
    Assert.assertNotNull(result);
    Assert.assertTrue(Arrays.equals(new double[]{}, result));
  }

  @Test
  public void medianSlidingWindowEmpty() {
    int[] array = new int[]{};
    double[] result = mSolution.medianSlidingWindow(array, 0);
    Assert.assertNotNull(result);
    Assert.assertTrue(Arrays.equals(new double[]{}, result));
  }

  @Test
  public void medianSlidingWindowKSizeOverFlow() {
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    double[] result = mSolution.medianSlidingWindow(array, 9);
    Assert.assertNotNull(result);
    Assert.assertTrue(Arrays.equals(new double[]{}, result));
  }

  //
  //  Sliding Window Median -
  // https://leetcode.com/problems/sliding-window-median/
  // End
  //
  //   Find Median from Data Stream -
  // https://leetcode.com/problems/find-median-from-data-stream/
  //
  @Test
  public void findMedianFromDataStream() {
    MedianFinder finder = mSolution.new MedianFinder();
    finder.addNum(1);
    finder.addNum(2);
    double median1 = finder.findMedian();
    finder.addNum(3);
    double median2 = finder.findMedian();
    Assert.assertEquals(1.5, median1, 0.01);
    Assert.assertEquals(2.0, median2, 0.01);
  }

  @Test
  public void findMedianFromDataStreamLargeNum() {
    MedianFinder finder = mSolution.new MedianFinder();
    finder.addNum(2147483647);
    finder.addNum(2147483647);
    double median1 = finder.findMedian();
    finder.addNum(2147483647);
    double median2 = finder.findMedian();
    Assert.assertEquals(2147483647.0, median1, 0.1);
    Assert.assertEquals(2147483647.0, median2, 0.1);
  }
  //
  //   Find Median from Data Stream -
  // https://leetcode.com/problems/find-median-from-data-stream/
  // End

  @Test
  public void topKFrequent() {
    int[] array = {1, 1, 1, 2, 2, 3};
    int[] topKFreq = mSolution.topKFrequent(array, 2);
    Assert.assertNotNull(topKFreq);
    Assert.assertEquals(2, topKFreq.length);
    Assert.assertEquals(1, topKFreq[0]);
    Assert.assertEquals(2, topKFreq[1]);
  }

  @Test
  public void topKFrequent1() {
    int[] array = {1};
    int[] topKFreq = mSolution.topKFrequent(array, 1);
    Assert.assertNotNull(topKFreq);
    Assert.assertEquals(1, topKFreq.length);
    Assert.assertEquals(1, topKFreq[0]);
  }

  @Test
  public void topKFrequentInstinct() {
    int[] array = {1, 1, 1, 2, 2, 3};
    int[] topKFreq = mSolution.topKFrequentInstinct(array, 2);
    Assert.assertNotNull(topKFreq);
    Assert.assertEquals(2, topKFreq.length);
    Assert.assertEquals(1, topKFreq[0]);
    Assert.assertEquals(2, topKFreq[1]);
  }

  @Test
  public void topKFrequentInstinct1() {
    int[] array = {1};
    int[] topKFreq = mSolution.topKFrequentInstinct(array, 1);
    Assert.assertNotNull(topKFreq);
    Assert.assertEquals(1, topKFreq.length);
    Assert.assertEquals(1, topKFreq[0]);
  }
}
