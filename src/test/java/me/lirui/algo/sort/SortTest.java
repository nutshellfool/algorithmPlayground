package me.lirui.algo.sort;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * MergeSort Tester.
 *
 * @author Richard Li
 * @since
 *     <pre>四月 9, 2017</pre>
 *
 * @version 1.0
 */
public class SortTest {

  @Before
  public void before() {}

  @After
  public void after() {}

  @Test
  public void testBubbleSort() {
    BubbleSort bubbleSort =
        new BubbleSort() {
          @Override
          public void onPostSort(String outPut, int[] resultData) {
            Assert.assertTrue(_isInAscendOrder(resultData));
          }
        };
    bubbleSort.doSort();
  }

  @Test
  public void testInsertionSort() {
    InsertionSort insertionSort =
        new InsertionSort() {
          @Override
          public void onPostSort(String outPut, int[] result) {
            Assert.assertTrue(_isInAscendOrder(result));
          }
        };
    insertionSort.doSort();
  }

  /** Method: onDoSort(int[] inputData) */
  @Test
  public void testMergeSort() {
    MergeSort mergeSort =
        new MergeSort() {
          @Override
          public void onPostSort(String outPut, int[] result) {
            Assert.assertTrue(_isInAscendOrder(result));
          }
        };

    mergeSort.doSort();
  }

  @Test
  public void testHeapSort() {
    HeapSort heapSort =
        new HeapSort() {
          @Override
          public void onPostSort(String outPut, int[] result) {
            Assert.assertTrue(_isInAscendOrder(result));
          }
        };
    heapSort.doSort();
  }

  private boolean _isInAscendOrder(int[] array) {
    if (array == null || array.length == 0) return true;

    for (int i = 0; i < array.length - 1; i++) {
      if (array[i + 1] < array[i]) return false;
    }

    return true;
  }
}
