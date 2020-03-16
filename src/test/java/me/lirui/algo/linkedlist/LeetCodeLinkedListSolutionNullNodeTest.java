package me.lirui.algo.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeLinkedListSolutionNullNodeTest {

  private LeetCodeLinkedListSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeLinkedListSolution();
  }

  @Test
  public void addTwoNumbers() {
    SingleLinkedNode node = mSolution.addTwoNumbers(null, null);
    Assert.assertNull(node);
  }

  @Test
  public void addTwoNumbersNode1Null() {
    SingleLinkedList list = new SingleLinkedList();
    list.appendNodeToTail(2);

    SingleLinkedNode node = mSolution.addTwoNumbers(null, list.getHeadNode().next);
    Assert.assertNotNull(node);
    Assert.assertEquals(2, node.getValue());
  }

  @Test
  public void addTwoNumbersNode2Null() {
    SingleLinkedList list1 = new SingleLinkedList();
    list1.appendNodeToTail(1);

    SingleLinkedNode node = mSolution.addTwoNumbers(list1.getHeadNode().next, null);
    Assert.assertNotNull(node);
    Assert.assertEquals(1, node.getValue());
  }

  @Test
  public void addTwoNumbers2() {
    SingleLinkedNode node = mSolution.addTwoNumbers2(null, null);
    Assert.assertNull(node);
  }

  @Test
  public void addTwoNumbers2Node1Null() {
    SingleLinkedList list = new SingleLinkedList();
    list.appendNodeToTail(2);

    SingleLinkedNode node = mSolution.addTwoNumbers2(null, list.getHeadNode().next);
    Assert.assertNotNull(node);
    Assert.assertEquals(2, node.getValue());
  }

  @Test
  public void addTwoNumbers2Node2Null() {
    SingleLinkedList list1 = new SingleLinkedList();
    list1.appendNodeToTail(1);

    SingleLinkedNode node = mSolution.addTwoNumbers2(list1.getHeadNode().next, null);
    Assert.assertNotNull(node);
    Assert.assertEquals(1, node.getValue());
  }

  @Test
  public void swapPairsNullHeadNode() {
    SingleLinkedNode node = mSolution.swapPairs(null);
    Assert.assertNull(node);
  }

  @Test
  public void swapPairsSoloNode() {
    SingleLinkedNode dummyNode = new SingleLinkedNode();
    SingleLinkedNode node = mSolution.swapPairs(dummyNode);
    Assert.assertEquals(node, dummyNode);
  }

  @Test
  public void swapPairsIterationNullHeadNode() {
    SingleLinkedNode node = mSolution.swapPairsIterationImpl(null);
    Assert.assertNull(node);
  }

  @Test
  public void swapPairsIterationSoloNode() {
    SingleLinkedNode dummyNode = new SingleLinkedNode();
    SingleLinkedNode node = mSolution.swapPairsIterationImpl(dummyNode);
    Assert.assertEquals(node, dummyNode);
  }

  @Test
  public void reverseKGroup() {
    SingleLinkedNode node = mSolution.reverseKGroup(null, 2);
    Assert.assertNull(node);
  }

  @Test
  public void reverseKGroupSoloNode() {
    SingleLinkedNode dummyNode = new SingleLinkedNode();
    SingleLinkedNode node = mSolution.reverseKGroup(dummyNode, 2);
    Assert.assertNotNull(node);
    Assert.assertEquals(dummyNode, node);
  }
}