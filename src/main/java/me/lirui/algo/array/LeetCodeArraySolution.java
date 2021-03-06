package me.lirui.algo.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

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
    rightMax[length - 1] = height[length - 1];
    for (int i = 1; i < length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    for (int j = length - 1 - 1; j >= 0; j--) {
      rightMax[j] = Math.max(rightMax[j + 1], height[j]);
    }

    for (int i = 1; i < length - 1; i++) {
      int bucketMin = Math.min(leftMax[i], rightMax[i]);
      unitOfTrapped += bucketMin - height[i];
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

  void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int pointerFront = 0;
    int pointerRear = nums.length - 1;
    int current = 0;
    while (current <= pointerRear) {
      if (nums[current] == 0) {
        swap(nums, current, pointerFront);
        current++;
        pointerFront++;
      } else if (nums[current] == 2) {
        swap(nums, current, pointerRear);
        pointerRear--;
      } else {
        current++;
      }
    }
  }

  private void swap(int[] array, int indexSwap1, int indexSwap2) {
    int temp = array[indexSwap1];
    array[indexSwap1] = array[indexSwap2];
    array[indexSwap2] = temp;
  }


  void sortColorsInstinct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    Arrays.sort(nums);
  }

  void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int lastNotZeroIndex = 0;
    int current = 0;
    while (current < nums.length) {
      if (nums[current] != 0) {
        swap(nums, current, lastNotZeroIndex);
        lastNotZeroIndex++;
      }
      current++;
    }
  }

  int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0 || envelopes[0] == null
        || envelopes[0].length < 2) {
      return 0;
    }

    int maxLength = 0;
    // sort the width dimension (envelopes(w,h))
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] arr1, int[] arr2) {
        if (arr1[0] == arr2[0]) {
          return arr2[1] - arr1[1];
        } else {
          return arr1[0] - arr2[0];
        }
      }
    });

    // LIS the height dimension
    int[] dp = new int[envelopes.length + 1];

    for (int[] envelop : envelopes) {
      int left = 0;
      int right = maxLength;
      int middle;
      while (left < right) {
        //
        middle = left + (right - left) / 2;
        if (dp[middle] < envelop[1]) {
          left = middle + 1;
        } else {
          right = middle;
        }
      }

      dp[left] = envelop[1];
      if (maxLength == left) {
        maxLength++;
      }
    }

    return maxLength;
  }

  // Merge Intervals
  // https://leetcode.com/problems/merge-intervals/
  private class IntervalComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
    }
  }

  int[][] merge(int[][] intervals) {

    if (intervals == null || intervals.length == 0 || intervals[0] == null
        || intervals[0].length < 2) {
      return null;
    }

    Arrays.sort(intervals, new IntervalComparator());
    LinkedList<int[]> mergedList = new LinkedList<>();

    for (int[] interval : intervals) {
      if (mergedList.size() == 0 || mergedList.getLast()[1] < interval[0]) {
        mergedList.add(interval);
      } else {
        mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][2]);
  }
}
