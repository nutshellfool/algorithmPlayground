package me.lirui.algo.sort;

import java.util.Arrays;

/**
 * An Implementation of merge sort
 *
 * <p>Complexity Analysis: Time complexity : O(N log N) Space complexity : No auxiliary space
 *
 * <p>Pseudo Code: merge-sort(A, p, r) if p < r q = [(p+r) / 2] merge-sort(A, p, q) merge-sort(A, q
 * + 1, r) Merge(A, p, q, r )
 *
 * <p>Created by RichardLee on 2017/4/2.
 */
public class MergeSort extends SortStub {
  @Override
  public int[] onPrepareInputData() {
    return new int[] {4, 3, 2, 1};
  }

  @Override
  public void onDoSort(int[] inputData) {
    super.onDoSort(inputData);
    _mergeSort(inputData);
    System.out.println("");
  }

  private void _mergeSort(int[] array) {
    if (array == null || array.length < 2) return;

    int mid = array.length / 2;
    int[] leftArray = Arrays.copyOfRange(array, 0, mid);
    int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

    _mergeSort(leftArray);
    _mergeSort(rightArray);

    _mergeArrarys(array, leftArray, rightArray);
  }

  private void _mergeArrarys(int[] array, int[] leftArray, int[] rightArray) {
    if (array == null) return;
    if (leftArray == null) {
      array = rightArray;
      return;
    }
    if (rightArray == null) {
      array = leftArray;
      return;
    }

    int leftLength = leftArray.length;
    int rightLength = rightArray.length;

    int i = 0;
    int j = 0;
    int k = 0;
    while (i < leftLength && j < rightLength) {
      if (leftArray[i] > rightArray[j]) {
        array[k++] = rightArray[j++];
      } else {
        array[k++] = leftArray[i++];
      }
    }
    while (i < leftLength) {
      array[k++] = leftArray[i++];
    }

    while (j < rightLength) {
      array[k++] = rightArray[j++];
    }
  }
}
