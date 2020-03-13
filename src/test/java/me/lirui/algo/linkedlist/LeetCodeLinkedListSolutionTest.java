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
    mLinkedListAlpha.appendNodeToTail(1);
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
    Assert.assertEquals(0, newHead.getValue());
    Assert.assertEquals(0, newHead.next.getValue());
    Assert.assertEquals(0, newHead.next.next.getValue());
    Assert.assertEquals(1, newHead.next.next.next.getValue());
    Assert.assertNull(newHead.next.next.next.next);
  }
}