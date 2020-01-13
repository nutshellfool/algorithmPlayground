package me.lirui.algo.sort;

/**
 * An Implementation of heap sort
 *
 * <p>Complexity Analysis: Time complexity : O(N log N) Space complexity : O(N)
 *
 * <p>Created by RichardLee on 2017/4/4.
 */
public class HeapSort extends SortStub {
  @Override
  public void onDoSort(int[] inputData) {
    super.onDoSort(inputData);
    // Actually the heap sort array need an array start from index 1, index 0 store nothing,
    // this is just easy for algorithm to manipulate the element in heapify
    int[] heapInputArray = new int[inputData.length + 1];
    System.arraycopy(inputData, 0, heapInputArray, 1, inputData.length);
    buildHeap(heapInputArray, inputData.length);
    int k = inputData.length;
    while (k > 1) {
      swap(heapInputArray, 1, k);
      --k;
      heapify(heapInputArray, k, 1);
    }

    System.arraycopy(heapInputArray, 1, inputData, 0, heapInputArray.length - 1);
  }

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 1; --i) {
      heapify(a, n, i);
    }
  }

  private static void heapify(int[] a, int n, int i) {
    while (true) {
      int maxPos = i;
      if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
      if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
      if (maxPos == i) break;
      swap(a, i, maxPos);
      i = maxPos;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
