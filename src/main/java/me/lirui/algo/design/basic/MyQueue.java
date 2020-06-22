package me.lirui.algo.design.basic;

import java.util.Stack;

class MyQueue {

  private Stack<Integer> stack;
  private Stack<Integer> stackOut;
  private int front;

  /**
   * Initialize your data structure here.
   */
  MyQueue() {
    stack = new Stack<>();
    stackOut = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  void push(int x) {
    if (stack.isEmpty()) {
      front = x;
    }

    while (!stack.isEmpty()) {
      stackOut.push(stack.pop());
    }

    stackOut.push(x);
    while (!stackOut.isEmpty()) {
      stack.push(stackOut.pop());
    }
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  int pop() {
    int poped = stack.pop();
    if (!stack.isEmpty()) {
      front = stack.peek();
    }
    return poped;

  }

  /**
   * Get the front element.
   */
  int peek() {
    return front;

  }

  /**
   * Returns whether the queue is empty.
   */
  boolean empty() {
    return stack.isEmpty();
  }
}
