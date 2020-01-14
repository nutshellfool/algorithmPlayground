package me.lirui.algo.binarysearch;

class BinarySearch {

  int binarySearchStand(int[] array, int target) {
    if (array == null || array.length == 0) return -1;

    int left = 0, right = array.length - 1;
    int mid = left + (right - left) / 2;
    while (left <= right) {
      if (array[mid] == target) return mid;

      if (array[mid] > target) right = mid = 1;
      if (array[mid] < target) left = mid + 1;
    }

    return -1;
  }
}
