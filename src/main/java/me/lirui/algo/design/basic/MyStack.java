package me.lirui.algo.design.basic;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

  private Queue<Integer> queue;
  private Queue<Integer> queueOut;
  private int top;

  MyStack() {
    queue = new LinkedList<>();
    queueOut = new LinkedList<>();
  }

  /**
   * Push element x onto stack.
   */
  void push(int x) {
    queue.add(x);
    //noinspection SuspiciousNameCombination
    top = x;
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  int pop() {
    while (queue.size() > 1) {
      top = queue.remove();
      queueOut.add(top);
    }

    int poped = queue.remove();
    Queue<Integer> swapQueue = queue;
    queue = queueOut;
    queueOut = swapQueue;

    return poped;
  }

  /**
   * Get the top element.
   */
  int top() {
    return top;
  }

  /**
   * Returns whether the stack is empty.
   */
  boolean empty() {
    return queue.isEmpty();
  }
}

