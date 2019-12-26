package me.lirui.algo.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListOneNodeTest {

  private SingleLinkedList mSingleLinkedList;

  @Before
  public void before() {
    this.mSingleLinkedList = new SingleLinkedList();
    mSingleLinkedList.appendNodeToTail(1);
  }

  @After
  public void after() {
    this.mSingleLinkedList.clearList();
  }

  /** Method: getHeadNode() */
  @Test
  public void testGetHeadNode() {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    Assert.assertNotNull(headNode);
  }

  /** Method: appendNodeToTail(int value) */
  @Test
  public void testAppendNodeToTail() {
    mSingleLinkedList.appendNodeToTail(4);
    Assert.assertEquals(2, mSingleLinkedList.getSize());
  }

  /** Method: searchNode(int value) */
  @Test
  public void testSearchNodeExisted() {
    SingleLinkedNode foundNode = mSingleLinkedList.searchNode(1);
    Assert.assertNotNull(foundNode);
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
    Assert.assertNotNull(mSingleLinkedList.getHeadNode());
    Assert.assertNull(mSingleLinkedList.getHeadNode().getNext());
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
    SingleLinkedNode middleNode = mSingleLinkedList.middleNode(headNode.next);
    Assert.assertNotNull(middleNode);
    Assert.assertEquals(1, middleNode.getValue());
  }

  @Test
  public void testRemoveNthFromEnd() {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    SingleLinkedNode node = mSingleLinkedList.removeNthFromEnd(headNode.next, 1);
    // [1,3]
    Assert.assertNull(node);
  }

  private void _reverseListTestCase(SingleLinkedNode newHead, SingleLinkedList reversedList) {
    int listSize = reversedList.getSize();
    Assert.assertEquals(listSize, 1);
    Assert.assertNotNull(newHead);
    Assert.assertEquals(newHead.getValue(), 1);
  }
}
