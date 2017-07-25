package me.lirui.algo.linkedlist;

import java.util.HashMap;

/** Created by RichardLee on 2017/3/28. */
public class SingleLinkedList {

  private SingleLinkedNode mHeadNode;
  private int mSize;

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
   * @param value
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
   * @param value
   * @return
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
   * @param value
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
   * @return
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
   * @return
   */
  public boolean hasCycle2() {
    if (mHeadNode == null) return false;
    HashMap<SingleLinkedNode, SingleLinkedNode> tempMap = new HashMap();
    SingleLinkedNode p = mHeadNode;

    while (p.getNext() != null) {
      if (tempMap.get(p) == null) {
        tempMap.put(p, p);
      } else {
        tempMap.remove(p);
      }
      //            Actually this code have the same effect with above 5 lines code.
      //            SingleLinkedNode value = tempMap.get(p) == null ? tempMap.put(p,p) : tempMap.remove(p);

      if (tempMap.size() == 0) return true;

      p = p.getNext();
    }

    return false;
  }
}
