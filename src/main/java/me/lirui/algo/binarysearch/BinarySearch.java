package me.lirui.algo.binarysearch;

class BinarySearch {
  //  Binary Search
  // https://leetcode.com/problems/binary-search/
  //
  int binarySearchStandard(int[] array, int target) {
    if (array == null || array.length == 0) return -1;

    int left = 0, right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) return mid;
      if (array[mid] < target) left = mid + 1;
      if (array[mid] > target) right = mid - 1;
    }

    return -1;
  }
  //  Binary Search
  // https://leetcode.com/problems/binary-search/
  // End
}
