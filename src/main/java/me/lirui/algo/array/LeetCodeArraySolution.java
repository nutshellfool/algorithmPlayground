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

  // Trapping Rain Water
  // https://leetcode.com/problems/trapping-rain-water/

  // Time complexity $O(n^2)$
  // Space complexity $O(1)$
  int trapInBrutalForceWay(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }
    int size = height.length;
    int unitOfTrapped = 0;

    int leftMax;
    int rightMax;

    for (int i = 1; i < size - 1; i++) {
      leftMax = 0;
      rightMax = 0;
      //findLeft max
      for (int j = i; j >= 0; j--) {
        leftMax = Math.max(leftMax, height[j]);
      }

      for (int k = i; k < size; k++) {
        rightMax = Math.max(rightMax, height[k]);
      }

      int bucketMin = Math.min(leftMax, rightMax);
      int trappedUnit = bucketMin - height[i];
      unitOfTrapped += trappedUnit;
    }

    return unitOfTrapped;
  }
  // Follow up: the brutal force way time complexity can not acceptable,
  //            Any optional way to improve algorithm runtime performance?

  //  common thinking: use space trade with runtime performance.
  //
  //  DP states definition:
  //        leftMax[i] : the Max height at position "i" on left side;
  //        rightMax[i] : the Max height at position "i" on right side;

  //  Time complexity : $O(n)$
  //  Space complexity : $O(n)$
  int trapDynamicProgrammingSolution(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }

    int length = height.length;
    int unitOfTrapped = 0;
    int[] leftMax = new int[length];
    int[] rightMax = new int[length];

    leftMax[0] = height[0];
    rightMax[0] = height[length - 1];
    for (int i = 1; i < length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
    }

    for (int j = length - 1 - 1; j >= 0; j--) {
      rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
    }

    for (int i = 1; i < length - 1; i++) {
      int bucketMin = Math.min(leftMax[i], rightMax[i]);

      if (height[i] < bucketMin) {
        unitOfTrapped += bucketMin - height[i];
      }
    }

    return unitOfTrapped;
  }
  // Follow up: seems the runtime performance is Ok,
  //            but any idea on space?
  //            Any possible solution for
  //            Time complexity: $O(n)$
  //            Space complexity: $O(1)$?

  int trap(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }

    int length = height.length;
    int left = 0;
    int right = length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int unitOfTrapped = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          unitOfTrapped += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          unitOfTrapped += rightMax - height[right];
        }
        right--;
      }
    }

    return unitOfTrapped;
  }
  // Trapping Rain Water
  // https://leetcode.com/problems/trapping-rain-water/
  // End
}
