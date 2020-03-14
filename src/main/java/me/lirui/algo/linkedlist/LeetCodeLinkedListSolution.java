package me.lirui.algo.linkedlist;

import java.util.Stack;

class LeetCodeLinkedListSolution {

  SingleLinkedNode addTwoNumbers(SingleLinkedNode l1, SingleLinkedNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }

    SingleLinkedNode newDummyHead = new SingleLinkedNode();
    SingleLinkedNode resultNode = newDummyHead;
    SingleLinkedNode l1Pointer = l1;
    SingleLinkedNode l2pointer = l2;
    int carry = 0;

    while (l1Pointer != null || l2pointer != null) {

      // do the calculation work
      int sum = carry;

      if (l1Pointer != null) {
        sum += l1Pointer.getValue();
        l1Pointer = l1Pointer.next;
      }

      if (l2pointer != null) {
        sum += l2pointer.getValue();
        l2pointer = l2pointer.next;
      }

      SingleLinkedNode newNode = new SingleLinkedNode();
      newNode.setValue(sum % 10);
      resultNode.next = newNode;
      resultNode = resultNode.next;
      carry = sum / 10;
    }

    if (carry == 1) {
      SingleLinkedNode node = new SingleLinkedNode();
      node.setValue(1);
      resultNode.next = node;
    }

    return newDummyHead.next;
  }

  SingleLinkedNode addTwoNumbers2(SingleLinkedNode l1, SingleLinkedNode l2) {

    Stack<Integer> l1Stack = new Stack<>();
    Stack<Integer> l2Stack = new Stack<>();

    while (l1 != null) {
      l1Stack.push(l1.getValue());
      l1 = l1.next;
    }

    while (l2 != null) {
      l2Stack.push(l2.getValue());
      l2 = l2.next;
    }

    SingleLinkedNode dummyNode = null;
    int carry = 0;

    while (!l1Stack.empty() || !l2Stack.empty() || carry != 0) {

      int sum = carry;

      if (!l1Stack.empty()) {
        sum += l1Stack.pop();
      }
      if (!l2Stack.empty()) {
        sum += l2Stack.pop();
      }

      SingleLinkedNode newHead = new SingleLinkedNode();
      newHead.setValue(sum % 10);
      newHead.next = dummyNode;
      dummyNode = newHead;

      carry = sum / 10;
    }

    return dummyNode;
  }
}
