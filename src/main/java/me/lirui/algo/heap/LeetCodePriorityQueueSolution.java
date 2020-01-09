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

}
