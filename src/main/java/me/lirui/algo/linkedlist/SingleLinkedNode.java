package me.lirui.algo.linkedlist;

/** Created by RichardLee on 2017/3/21. */
public class SingleLinkedNode {
  private int value;
  SingleLinkedNode next;

  SingleLinkedNode() {}

  public SingleLinkedNode(int value, SingleLinkedNode next) {
    super();
    this.value = value;
    this.next = next;
  }

  int getValue() {
    return value;
  }

  void setValue(int value) {
    this.value = value;
  }

  SingleLinkedNode getNext() {
    return next;
  }

  void setNext(SingleLinkedNode next) {
    this.next = next;
  }
}
