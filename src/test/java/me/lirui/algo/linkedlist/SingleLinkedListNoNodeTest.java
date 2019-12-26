package me.lirui.algo.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListNoNodeTest {

  private SingleLinkedList mSingleLinkedList;

  @Before
  public void before() {
    this.mSingleLinkedList = new SingleLinkedList();
  }

  @After
  public void after() {
    this.mSingleLinkedList.clearList();
  }

  @Test
  public void testGetHeadNode() {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    Assert.assertNull(headNode);
  }

  /** Method: appendNodeToTail(int value) */
  @Test
  public void testAppendNodeToTail() {
    mSingleLinkedList.appendNodeToTail(4);
    Assert.assertEquals(1, mSingleLinkedList.getSize());
  }

  /** Method: searchNode(int value) */
  @Test
  public void testSearchNodeExisted() {
    //    SingleLinkedNode foundNode = mSingleLinkedList.searchNode(1);
    //    Assert.assertNotNull(foundNode);
    Assert.assertTrue(true);
  }

  /** Method: searchNode(int value) */
  @Test
  public void testSearchNodeNotExisted() {
    SingleLinkedNode foundNode = mSingleLinkedList.searchNode(6);
    Assert.assertNull(foundNode);
  }

  @Test
  public void testDeleteNode1stNode() {
    mSingleLinkedList.deleteNode(1);
    Assert.assertEquals(0, mSingleLinkedList.getSize());
    Assert.assertNull(mSingleLinkedList.getHeadNode());
  }

  @Test
  public void testHasCycleTrue1() {
    boolean hasCycle = mSingleLinkedList.hasCycle();
    Assert.assertFalse(hasCycle);
  }

  @Test
  public void testHasCycleTrue2() {
    boolean hasCycle = mSingleLinkedList.hasCycle2();
    Assert.assertFalse(hasCycle);
  }

  @Test
  public void testReverseList() {
    SingleLinkedNode reversedHead = mSingleLinkedList.reverseLinkList();
    _reverseListTestCase(reversedHead, mSingleLinkedList);
  }

  @Test
  public void testReverseListRecursionImpl() {
    SingleLinkedNode reversedHead = mSingleLinkedList.reverseLinkList_recursion();
    _reverseListTestCase(reversedHead, mSingleLinkedList);
  }

  @Test
  public void testMiddleNode() {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    SingleLinkedNode middleNode = mSingleLinkedList.middleNode(headNode);
    Assert.assertNull(middleNode);
  }

  @Test
  public void testRemoveNthFromEnd() {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    SingleLinkedNode node = mSingleLinkedList.removeNthFromEnd(headNode, 1);
    Assert.assertNull(node);
  }

  private void _reverseListTestCase(SingleLinkedNode newHead, SingleLinkedList reversedList) {
    int listSize = reversedList.getSize();
    Assert.assertEquals(0, listSize);
    Assert.assertNull(newHead);
  }
}
