package me.lirui.algo.array;

class LeetCodeArraySolution {

  // Container With Most Water
  // https://leetcode.com/problems/container-with-most-water/
  int maxAreaInBrutalForceWay(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }

    int arrayLength = height.length;
    int maxArea = 0;
    for (int i = 0; i < arrayLength; i++) {
      for (int j = i + 1; j < arrayLength; j++) {
        maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
      }
    }

    return maxArea;
  }

  int maxArea(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
  // Container With Most Water
  // https://leetcode.com/problems/container-with-most-water/
  // End
}
