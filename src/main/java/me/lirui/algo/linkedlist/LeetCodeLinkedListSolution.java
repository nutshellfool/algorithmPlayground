package me.lirui.algo.linkedlist;

import java.util.Stack;

class LeetCodeLinkedListSolution {

  // Add Two Numbers
  // https://leetcode.com/problems/add-two-numbers/
  SingleLinkedNode addTwoNumbers(SingleLinkedNode l1, SingleLinkedNode l2) {
    SingleLinkedNode newDummyHead = new SingleLinkedNode();
    SingleLinkedNode resultNode = newDummyHead;
    SingleLinkedNode l1Pointer = l1;
    SingleLinkedNode l2pointer = l2;
    int carry = 0;
    while (l1Pointer != null || l2pointer != null || carry != 0) {
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

    return newDummyHead.next;
  }
  // Add Two Numbers
  // https://leetcode.com/problems/add-two-numbers/
  // End

  // Add Two Numbers II
  // https://leetcode.com/problems/add-two-numbers-ii/
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
  // Add Two Numbers II
  // https://leetcode.com/problems/add-two-numbers-ii/
  // End

  // Swap Nodes in Pairs
  // https://leetcode.com/problems/swap-nodes-in-pairs/
  SingleLinkedNode swapPairs(SingleLinkedNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    SingleLinkedNode node = head.next;
    head.next = swapPairs(head.next.next);
    node.next = head;
    return node;
  }

  SingleLinkedNode swapPairsIterationImpl(SingleLinkedNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    SingleLinkedNode dummyNode = new SingleLinkedNode();
    dummyNode.next = head;

    SingleLinkedNode prevNode = dummyNode;

    while (head != null && head.next != null) {
      SingleLinkedNode firstNode = head;
      SingleLinkedNode secondNode = head.next;

      prevNode.next = secondNode;
      firstNode.next = secondNode.next;
      secondNode.next = firstNode;

      prevNode = firstNode;
      head = firstNode.next;
    }

    return dummyNode.next;
  }
  // Swap Nodes in Pairs
  // https://leetcode.com/problems/swap-nodes-in-pairs/
  // End

  // Reverse Nodes in k-Group
  // https://leetcode.com/problems/reverse-nodes-in-k-group/
  SingleLinkedNode reverseKGroup(SingleLinkedNode head, int k) {
    SingleLinkedNode dummy = new SingleLinkedNode();
    dummy.next = head;

    SingleLinkedNode pre = dummy;
    SingleLinkedNode end = dummy;

    while (end.next != null) {
      for (int i = 0; i < k && end != null; i++) {
        end = end.next;
      }
      if (end == null) {
        break;
      }
      SingleLinkedNode start = pre.next;
      SingleLinkedNode next = end.next;
      end.next = null;
      pre.next = reverse(start);
      start.next = next;
      pre = start;

      end = pre;
    }
    return dummy.next;
  }

  private SingleLinkedNode reverse(SingleLinkedNode node) {
    if (node == null) {
      return node;
    }

    SingleLinkedNode currentNode = node;
    SingleLinkedNode previousNode = null;

    SingleLinkedNode tempNodeForCurNext;
    while (currentNode != null) {
      tempNodeForCurNext = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = tempNodeForCurNext;
    }
    return previousNode;
  }
  // Reverse Nodes in k-Group
  // https://leetcode.com/problems/reverse-nodes-in-k-group/
  // End

  SingleLinkedNode deleteDuplicates(SingleLinkedNode head) {
    SingleLinkedNode currentNode = head;
    while (currentNode != null && currentNode.next != null) {
      if (currentNode.next.getValue() == currentNode.getValue()) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }
    }

    return head;
  }

  SingleLinkedNode deleteDuplicates2(SingleLinkedNode head) {
    SingleLinkedNode currentNode = head;
    SingleLinkedNode preNode = null;
    while (currentNode != null && currentNode.next != null) {
      if (currentNode.next.getValue() == currentNode.getValue()) {
        while (currentNode.next != null && currentNode.next.getValue() == currentNode.getValue()) {
          currentNode = currentNode.next;
        }
        if (preNode != null) {
          preNode.next = currentNode.next;
        } else {
          head = currentNode.next;
        }
      } else {
        preNode = currentNode;
      }

      currentNode = currentNode.next;
    }

    return head;
  }
}
