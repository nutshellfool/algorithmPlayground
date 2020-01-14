package me.lirui.algo.sort;

/**
 * An implementation of quick-sort algorithm.
 *
 * <p>complexity analysis: Time complexity: O(n*log n) Space complexity: n length auxiliary space or
 * no auxiliary space (in-place version)
 *
 * <p>Pseudo code: // auxiliary version quicksort (A) if (A.length <= 1) return A; select a pivot
 * value q from A for x in A except pivot: if (x < pivot) then add x to less if (x >= pivot) then
 * add x to greater add pivot to pivotlist return concatenate (quicksort(less), pivotList,
 * quicksort(greater))
 *
 * <p>// No auxiliary version quicksort(A, left, right) if right > left select a pivot value
 * a[pivotIndex] pivotNewIndex := partition(a, left, right, pivotIndex) quicksort(A, left,
 * pivotNewIndex - 1) quicksort(A, pivotNewIndex + 1, right)
 *
 * <p>partition(a, left, right, pivotIndex) pivotValue := a[pivotIndex] swap(a[pivotIndex],
 * a[right]) storeIndex := left for i from left to right-1 if a[i] <＝ pivotValue swap(a[storeIndex],
 * a[i]) storeIndex := storeIndex + 1 swap(a[right], a[storeIndex]) return storeIndex
 *
 * <p>Created by RichardLee on 2017/4/3.
 */
public class QuickSort extends SortStub {

  @Override
  public void onDoSort(int[] inputData) {
    super.onDoSort(inputData);
    quickSortRe(inputData, 0, inputData.length - 1);
  }

  private void quickSortRe(int[] array, int p, int r) {
    if (p >= r) return;

    int q = partition(array, p, r);
    quickSortRe(array, p, q - 1);
    quickSortRe(array, q + 1, r);
  }

  private int partition(int[] array, int p, int r) {
    int pivot = array[r];
    int i = p;
    for (int j = p; j < r; ++j) {
      if (array[j] < pivot) {
        if (i == j) {
          ++i;
        } else {
          int tmp = array[i];
          array[i++] = array[j];
          array[j] = tmp;
        }
      }
    }

    int tmp = array[i];
    array[i] = array[r];
    array[r] = tmp;

    return i;
  }
}
