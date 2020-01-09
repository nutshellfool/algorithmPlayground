package me.lirui.algo.heap;

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
    if (nums == null || (k < 0 || k > nums.length)) return Integer.MIN_VALUE;

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
  //  Kth Largest Element in an Array -
  // https://leetcode.com/problems/kth-largest-element-in-an-array/
  // End

}
