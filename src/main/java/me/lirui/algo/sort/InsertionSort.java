package me.lirui.algo.sort;

/**
 *  An Implementation of Insertion Sort.
 *
 *  Complexity Analysis:
 *      Time Complexity: O(N^2)
 *      Space Complexity: No auxiliary space.
 *
 *  pseudo code:
 *
 *      for j = 2 to A.length
 *          key = A[j]
 *          // insert A[j] into the sorted array A[1...j - 1]
 *          i = j - 1
 *          while i > 0 and A[i] > key
 *              A[i + 1] = A[i]
 *              A[i] = key
 *              i = i - 1
 *
 * Created by RichardLee on 2017/4/2.
 */
public class InsertionSort extends SortStub{

    @Override
    public void onDoSort(int[] inputData) {
        super.onDoSort(inputData);

        int len = inputData != null ? inputData.length : -1;
        if (len > 0) {
            for (int j = 1; j < len; j++) {
                int key = inputData[j];
                int i = j - 1;
                while (i >= 0 && inputData[i] > key) {
                    inputData[i + 1] = inputData[i];
                    inputData[i] = key;
                    i --;
                }
            }
        }
    }
}
