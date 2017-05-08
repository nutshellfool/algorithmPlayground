package me.lirui.algo.sort;

/**
 *  An implementation of quicksort algorithm.
 *
 *  complexity analysis:
 *          Time complexity: O(n*log n)
 *          Space complexity: n length auxiliary space or no auxiliary space (in-place version)
 *
 *  Pseudo code:
 *          // auxiliary version
 *          quicksort (A)
 *              if (A.length <= 1) return A;
 *              select a pivot value q from A
 *              for x in A except pivot:
 *                  if (x < pivot) then add x to less
 *                  if (x >= pivot) then add x to greater
 *              add pivot to pivotlist
 *          return concatenate (quicksort(less), pivotList, quicksort(greater))
 *
 *
 *          // No auxiliary version
 *          quicksort(A, left, right)
 *              if right > left
 *                  select a pivot value  a[pivotIndex]
 *                  pivotNewIndex := partition(a, left, right, pivotIndex)
 *                  quicksort(A, left, pivotNewIndex - 1)
 *                  quicksort(A, pivotNewIndex + 1, right)
 *
 *          partition(a, left, right, pivotIndex)
 *              pivotValue := a[pivotIndex]
 *              swap(a[pivotIndex], a[right])
 *              storeIndex := left
 *              for i from left to right-1
 *                  if a[i] <＝ pivotValue
 *                  swap(a[storeIndex], a[i])
 *                  storeIndex := storeIndex + 1
 *              swap(a[right], a[storeIndex])
 *         return storeIndex
 *
 * Created by RichardLee on 2017/4/3.
 */
public class QuickSort extends SortStub {

    @Override
    public void onDoSort(int[] inputData) {
        super.onDoSort(inputData);

    }
}
