package me.lirui.algo.linkedlist;

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
}
