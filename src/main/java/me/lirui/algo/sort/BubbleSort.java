package me.lirui.algo.sort;

/**
 *  An Implements of Bubble sort.
 *
 *  Complexity Analysis:
 *              Time : O(N^2)
 *              Space : No auxiliary space
 *
 *  pseudo code:
 *
 *          for i = 1 to A.length -1
 *              for j = A.length down to i - 1
 *                  if A[j] < A[j - 1]
 *                      exchange A[j] with A[j - 1]
 *
 *
 * Created by RichardLee on 2017/4/2.
 */
public class BubbleSort extends SortStub{

    @Override
    public void onDoSort(int[] inputData) {
        super.onDoSort(inputData);

        int len = inputData != null ? inputData.length: -1;
        if (len > -1) {
            for (int i = 0; i < len; i++) {
                for (int j = len - 1; j > i; j--) {
                    if (inputData[j] < inputData[j - 1]){
                        _exchange(inputData, j, j - 1);
                    }
                }
            }
        }
    }

    private void _exchange(int[] array, int sourceIndex, int targetIndex){
        int len = array != null ? array.length: -1;

        if (sourceIndex < 0 || targetIndex < 0 ||
                sourceIndex >= len || targetIndex >= len) return;

        int temp = array[targetIndex];
        array[targetIndex] = array[sourceIndex];
        array[sourceIndex] = temp;
    }
}
