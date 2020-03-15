package me.lirui.algo.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeLinkedListSolutionTest {

  private LeetCodeLinkedListSolution mSolution;
  private SingleLinkedList mLinkedListAlpha;
  private SingleLinkedList mLinkedListBeta;

  @Before
  public void setUp() {
    mSolution = new LeetCodeLinkedListSolution();
    mLinkedListAlpha = new SingleLinkedList();
    mLinkedListAlpha.appendNodeToTail(9);
    mLinkedListAlpha.appendNodeToTail(9);
    mLinkedListAlpha.appendNodeToTail(9);

    mLinkedListBeta = new SingleLinkedList();
    mLinkedListBeta.appendNodeToTail(9);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void addTwoNumbers() {
    SingleLinkedNode newHead = mSolution
        .addTwoNumbers(mLinkedListAlpha.getHeadNode().next, mLinkedListBeta.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(8, newHead.getValue());
    Assert.assertEquals(0, newHead.next.getValue());
    Assert.assertEquals(0, newHead.next.next.getValue());
    Assert.assertEquals(1, newHead.next.next.next.getValue());
    Assert.assertNull(newHead.next.next.next.next);
  }

  @Test
  public void addTwoNumbers2() {
    SingleLinkedNode newHead = mSolution
        .addTwoNumbers2(mLinkedListAlpha.getHeadNode().next, mLinkedListBeta.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(1, newHead.getValue());
    Assert.assertEquals(0, newHead.next.getValue());
    Assert.assertEquals(0, newHead.next.next.getValue());
    Assert.assertEquals(8, newHead.next.next.next.getValue());
    Assert.assertNull(newHead.next.next.next.next);
  }

  @Test
  public void swapPairs() {
    SingleLinkedList linkedList = new SingleLinkedList();
    linkedList.appendNodeToTail(4);
    linkedList.appendNodeToTail(3);
    linkedList.appendNodeToTail(2);
    linkedList.appendNodeToTail(1);

    SingleLinkedNode newHead = mSolution.swapPairs(linkedList.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(3, newHead.getValue());
    Assert.assertEquals(4, newHead.next.getValue());
    Assert.assertEquals(1, newHead.next.next.getValue());
    Assert.assertEquals(2, newHead.next.next.next.getValue());
    Assert.assertNull(newHead.next.next.next.next);
  }

  @Test
  public void swapPairs3Nodes() {
    SingleLinkedList Linkedlist = new SingleLinkedList();
    Linkedlist.appendNodeToTail(1);
    Linkedlist.appendNodeToTail(9);
    Linkedlist.appendNodeToTail(2);

    SingleLinkedNode newHead = mSolution.swapPairs(Linkedlist.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(9, newHead.getValue());
    Assert.assertEquals(1, newHead.next.getValue());
    Assert.assertEquals(2, newHead.next.next.getValue());
    Assert.assertNull(newHead.next.next.next);
  }

  @Test
  public void swapPairs1Node() {
    SingleLinkedNode newHead = mSolution.swapPairs(mLinkedListBeta.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(9, newHead.getValue());
    Assert.assertNull(newHead.next);
  }

  @Test
  public void swapPairsIteration() {
    SingleLinkedList list = new SingleLinkedList();
    list.appendNodeToTail(9);
    list.appendNodeToTail(8);
    list.appendNodeToTail(7);
    list.appendNodeToTail(6);

    SingleLinkedNode newHead = mSolution.swapPairsIterationImpl(list.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(8, newHead.getValue());
    Assert.assertEquals(9, newHead.next.getValue());
    Assert.assertEquals(6, newHead.next.next.getValue());
    Assert.assertEquals(7, newHead.next.next.next.getValue());
    Assert.assertNull(newHead.next.next.next.next);
  }

  @Test
  public void swapPairsIteration3Nodes() {
    SingleLinkedList list = new SingleLinkedList();
    list.appendNodeToTail(6);
    list.appendNodeToTail(8);
    list.appendNodeToTail(0);

    SingleLinkedNode newHead = mSolution.swapPairsIterationImpl(list.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(8, newHead.getValue());
    Assert.assertEquals(6, newHead.next.getValue());
    Assert.assertEquals(0, newHead.next.next.getValue());
    Assert.assertNull(newHead.next.next.next);
  }

  @Test
  public void swapPairsIteration1Node() {
    SingleLinkedNode newHead = mSolution.swapPairsIterationImpl(mLinkedListBeta.getHeadNode().next);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(9, newHead.getValue());
    Assert.assertNull(newHead.next);
  }
}