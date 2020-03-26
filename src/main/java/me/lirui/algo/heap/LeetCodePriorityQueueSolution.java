package me.lirui.algo.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Objects;
import java.util.PriorityQueue;

class LeetCodePriorityQueueSolution {

  //
  //  Kth Largest Element in a Stream -
  // https://leetcode.com/problems/kth-largest-element-in-a-stream/
  //
  class KthLargest {

    // MinHeap
    final PriorityQueue<Integer> priorityQueue;
    final int limitSize;

    KthLargest(int k, int[] nums) {
      limitSize = k;
      priorityQueue = new PriorityQueue<>(k);

      for (int initNum : nums) {
        add(initNum);
      }
    }

    int add(int val) {
      // heap size check
      if (priorityQueue.size() < limitSize) {
        priorityQueue.offer(val);
      } else {
        // compare with heap top elements (k-largest)
        if (Objects.requireNonNull(priorityQueue.peek()) < val) {
          priorityQueue.poll();
          priorityQueue.offer(val);
        }
      }

      // return heap top element
      return Objects.requireNonNull(priorityQueue.peek());
    }
  }
  //
  //  Kth Largest Element in a Stream -
  // https://leetcode.com/problems/kth-largest-element-in-a-stream/
  // End

  //
  //  Kth Largest Element in an Array -
  // https://leetcode.com/problems/kth-largest-element-in-an-array/
  //
  int findKthLargest(int[] nums, int k) {
    if (nums == null || (k < 0 || k > nums.length)) {
      return Integer.MIN_VALUE;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    for (int numItem : nums) {
      if (pq.size() < k) {
        pq.offer(numItem);
      } else {
        if (Objects.requireNonNull(pq.peek(), "unboxing caused NPE") < numItem) {
          pq.poll();
          pq.offer(numItem);
        }
      }
    }

    return Objects.requireNonNull(pq.peek(), "unboxing caused NPE");
  }

  //
  //  Sliding Window Maximum -
  // https://leetcode.com/problems/sliding-window-maximum/
  //

  //  Time complexity : $O(N)$
  //  Space complexity : $O(k)$
  int[] maxSlidingWindowDeque(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return nums;
    }
    //
    // - Seems that if window size oversize the array
    // return the maximum element in array reasonable.
    //
    // - Actually in practical engineering, return null is also reasonable.
    if (k > nums.length) {
      Arrays.sort(nums);
      return new int[]{nums[nums.length - 1]};
    }

    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    int resultIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      deque.offerLast(i);

      if (deque.peek() == i - k) {
        deque.poll();
      }

      if (i >= k - 1) {
        result[resultIndex++] = nums[deque.peek()];
      }
    }

    return result;
  }


  //  Time Complexity: $O(N*log^k)$
  //  Space Complexity: $O(k)$
  int[] maxSlidingWindowHeap(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return nums;
    }
    //
    // - Seems that if window size oversize the array
    // return the maximum element in array reasonable.
    //
    // - Actually in practical engineering, return null is also reasonable.
    if (k > nums.length) {
      Arrays.sort(nums);
      return new int[]{nums[nums.length - 1]};
    }

    int[] result = new int[nums.length - k + 1];
    PriorityQueue<Integer> priorityQueue =
        new PriorityQueue<>(k, Collections.<Integer>reverseOrder());

    for (int i = 0; i < k; i++) {
      priorityQueue.offer(nums[i]);
    }

    result[0] = Objects.requireNonNull(priorityQueue.peek());

    for (int j = k; j < nums.length; j++) {
      priorityQueue.offer(nums[j]);
      priorityQueue.remove(nums[j - k]);
      result[j - k + 1] = Objects.requireNonNull(priorityQueue.peek());
    }

    return result;
  }

  //  Time Complexity: $O(N*k)$
  //  Space Complexity: $O(1)$
  int[] maxSlidingWindowBrutalForce(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return nums;
    }
    //
    // - Seems that if window size oversize the array
    // return the maximum element in array reasonable.
    //
    // - Actually in practical engineering, return null is also reasonable.
    if (k > nums.length) {
      Arrays.sort(nums);
      return new int[]{nums[nums.length - 1]};
    }

    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i <= nums.length - k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, nums[j]);
      }
      result[i] = max;
    }

    return result;
  }
  //
  //  Sliding Window Maximum -
  // https://leetcode.com/problems/sliding-window-maximum/
  // End

  //
  //  Sliding Window Median -
  // https://leetcode.com/problems/sliding-window-median/
  //
  double[] medianSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0 || nums.length < k) {
      return new double[]{};
    }
    long[] input = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      input[i] = nums[i];
    }
    return medianSlidingWindowLong(input, k);
  }

  private double[] medianSlidingWindowLong(long[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0 || nums.length < k) {
      return new double[]{};
    }
    int length = nums.length;
    double[] result = new double[length - k + 1];
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    PriorityQueue<Long> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

    for (int i = 0; i < length; i++) {
      if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
        maxHeap.offer(nums[i]);
      } else {
        minHeap.offer(nums[i]);
      }
      // heap maintain
      heapsBanlancefy(maxHeap, minHeap);

      if (i - k >= 0) {
        if (nums[i - k] > maxHeap.peek()) {
          minHeap.remove(nums[i - k]);
        } else {
          maxHeap.remove(nums[i - k]);
        }
      }

      heapsBanlancefy(maxHeap, minHeap);

      if (i >= k - 1) {
        if (k % 2 == 0) {
          result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
          result[i - k + 1] = maxHeap.peek();
        }
      }
    }

    return result;
  }

  private void heapsBanlancefy(PriorityQueue<Long> maxHeap, PriorityQueue<Long> minHeap) {
    while (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }

    while (minHeap.size() < maxHeap.size() - 1) {
      minHeap.offer(maxHeap.poll());
    }
  }
  //
  //  Sliding Window Median -
  // https://leetcode.com/problems/sliding-window-median/
  // End

  //   Find Median from Data Stream -
  // https://leetcode.com/problems/find-median-from-data-stream/
  //
  class MedianFinder {

    final PriorityQueue<Long> minHeap;
    final PriorityQueue<Long> maxHeap;

    /**
     * initialize your data structure here.
     */
    MedianFinder() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(100, Collections.<Long>reverseOrder());
    }

    void addNum(int num) {
      maxHeap.offer((long) num);
      minHeap.offer(maxHeap.poll());

      while (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
      while (minHeap.size() < maxHeap.size() - 1) {
        minHeap.offer(maxHeap.poll());
      }
    }

    double findMedian() {
      return maxHeap.size() > minHeap.size()
          ? maxHeap.peek()
          : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }
  //
  //   Find Median from Data Stream -
  // https://leetcode.com/problems/find-median-from-data-stream/
  // End
}
