package me.lirui.algo.linkedlist;

import java.util.Arrays;
import java.util.HashMap;

/** Created by RichardLee on 2017/3/28. */
public class SingleLinkedList {

  private SingleLinkedNode mHeadNode;
  private int mSize = 0;

  public SingleLinkedList() {
    super();
  }

  public SingleLinkedNode getHeadNode() {
    return mHeadNode;
  }

  public int getSize() {
    return mSize;
  }

  public void clearList() {
    this.mHeadNode = null;
  }

  /**
   * Append the node to the tail of the link
   *
   * @param value value
   */
  public void appendNodeToTail(int value) {
    if (this.mHeadNode == null) {
      this.mHeadNode = new SingleLinkedNode();
    }

    SingleLinkedNode n = this.mHeadNode;
    SingleLinkedNode node = new SingleLinkedNode();
    node.setValue(value);
    while (n.getNext() != null) {
      n = n.getNext();
    }

    n.setNext(node);
    mSize++;
  }

  /**
   * Search for the node with the specific value
   *
   * @param value value
   * @return the target node
   */
  public SingleLinkedNode searchNode(int value) {
    if (this.mHeadNode == null) return null;

    SingleLinkedNode n = this.mHeadNode;

    while (n.getNext() != null && n.getNext().getValue() != value) {
      n = n.getNext();
    }

    return n.getNext();
  }

  /**
   * Delete the node from the list
   *
   * @param value value
   */
  public void deleteNode(int value) {
    if (this.mHeadNode == null) return;

    SingleLinkedNode n = this.mHeadNode;

    while (n.getNext() != null && n.getNext().getValue() != value) {
      n = n.getNext();
    }

    if (n.getNext() != null && n.getNext().getValue() == value) {
      mSize--;
    }

    n.setNext(n.getNext() != null ? n.getNext().getNext() : null);
  }

  /**
   * Judge the LinkedList has cycle (no auxiliary space version)
   *
   * @return has cycle or not
   */
  public boolean hasCycle() {
    if (mHeadNode == null) return false;
    SingleLinkedNode normal = mHeadNode;
    SingleLinkedNode fast = mHeadNode;
    while (normal.getNext() != null && fast.getNext() != null && fast.getNext().getNext() != null) {
      normal = normal.getNext();
      fast = fast.getNext().getNext();
      if (normal == fast) return true;
    }

    return false;
  }

  /**
   * Judge the LinkedList has cycle (auxiliary space version)
   *
   * @return has cycle or not
   */
  public boolean hasCycle2() {
    if (mHeadNode == null) return false;
    HashMap<SingleLinkedNode, SingleLinkedNode> tempMap = new HashMap<>();
    SingleLinkedNode p = mHeadNode;

    while (p.getNext() != null) {
      if (tempMap.get(p) == null) {
        tempMap.put(p, p);
      } else {
        tempMap.remove(p);
      }
      //            Actually this code have the same effect with above 5 lines code.
      //            SingleLinkedNode value = tempMap.get(p) == null ? tempMap.put(p,p) :
      // tempMap.remove(p);

      if (tempMap.size() == 0) return true;

      p = p.getNext();
    }

    return false;
  }

  public SingleLinkedNode reverseLinkList() {
    // boundary cases:
    if (mHeadNode == null) {
      return null;
    }

    SingleLinkedNode currentNode = mHeadNode;
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

  public SingleLinkedNode reverseLinkList_recursion() {
    return _reverseList_recur_helper(mHeadNode);
  }

  private SingleLinkedNode _reverseList_recur_helper(SingleLinkedNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }

    SingleLinkedNode next = head.next;
    SingleLinkedNode newHeadNode = _reverseList_recur_helper(next);
    next.next = head;
    head.next = null;

    return newHeadNode;
  }

  public SingleLinkedNode middleNode(SingleLinkedNode head) {

    if (head == null) return null;
    if (head.next == null) return head;

    SingleLinkedNode slow = head;
    SingleLinkedNode fast = head;
    while (fast != null && fast.next != null) {

      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  //  public SingleLinkedNode removeNthFromEndComplex(SingleLinkedNode headNode, int n) {
  //    if (n <= 0 || n > mSize) return null;
  //    if (headNode == null) return null;
  //
  //    SingleLinkedNode tailNode = _reverseList_recur_helper(headNode);
  //    SingleLinkedNode node = tailNode;
  //    int loopIndex = 0;
  //    while (loopIndex != n - 1) {
  //      node = node.next;
  //      loopIndex++;
  //    }
  //    if (node != tailNode) deleteNode(node.getValue());
  //    return headNode;
  //  }

  public SingleLinkedNode removeNthFromEnd(SingleLinkedNode headNode, int n) {
    if (n <= 0 || n > mSize) return null;
    if (headNode == null) return null;

    SingleLinkedNode fast = headNode;
    for (int i = 1; i < n; i++) {
      fast = fast.next;
    }

    SingleLinkedNode slow = headNode;
    SingleLinkedNode prev = null;
    while (fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
    }

    // Here may cause NullPointerException, but in this implementation will never cause this.
    // parameter that greater or equal than the listNode size boundary case is considered in first
    // line.
    prev.next = prev.next.next;

    return headNode;
  }

  public static SingleLinkedNode mergeTwoLists(SingleLinkedNode l1, SingleLinkedNode l2) {

    if (l1 == null) return l2;
    if (l2 == null) return l1;

    SingleLinkedNode newHeadNode;
    if (l1.getValue() < l2.getValue()) {
      l1.setNext(mergeTwoLists(l1.next, l2));
      newHeadNode = l1;
    } else {
      l2.setNext(mergeTwoLists(l1, l2.next));
      newHeadNode = l2;
    }

    return newHeadNode;
  }

  public static SingleLinkedNode mergeTwoListsSimpleLoopImpl(
      SingleLinkedNode l1, SingleLinkedNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    SingleLinkedNode newHead = new SingleLinkedNode();
    SingleLinkedNode node = newHead;

    while (l1 != null && l2 != null) {
      if (l1.getValue() < l2.getValue()) {
        node.next = l1;
        l1 = l1.next;
      } else {
        node.next = l2;
        l2 = l2.next;
      }

      node = node.next;
    }

    node.next = l1 != null ? l1 : l2;

    return newHead.next;
  }

  public static SingleLinkedNode mergeKLists(SingleLinkedNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    if (lists.length == 1) return lists[0];

    int length = lists.length;
    int mid = length / 2;

    SingleLinkedNode leftNode = mergeKLists(Arrays.copyOfRange(lists, 0, mid));
    SingleLinkedNode rightNode = mergeKLists(Arrays.copyOfRange(lists, mid, length));

    return mergeTwoListsSimpleLoopImpl(leftNode, rightNode);
  }
}
