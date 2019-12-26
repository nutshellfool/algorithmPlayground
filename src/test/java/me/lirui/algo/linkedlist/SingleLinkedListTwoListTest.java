package me.lirui.algo.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTwoListTest {

  private SingleLinkedList mSingleLinkedListFirst;
  private SingleLinkedList mSingleLinkedListSecond;

  @Before
  public void before() {
    this.mSingleLinkedListFirst = new SingleLinkedList();
    this.mSingleLinkedListSecond = new SingleLinkedList();

    this.mSingleLinkedListFirst.appendNodeToTail(1);
    this.mSingleLinkedListFirst.appendNodeToTail(2);
    this.mSingleLinkedListFirst.appendNodeToTail(4);

    this.mSingleLinkedListSecond.appendNodeToTail(1);
    this.mSingleLinkedListSecond.appendNodeToTail(3);
    this.mSingleLinkedListSecond.appendNodeToTail(4);
  }

  @After
  public void after() {
    this.mSingleLinkedListFirst.clearList();
    this.mSingleLinkedListSecond.clearList();
  }

  @Test
  public void testMergeTwoLists() {
    SingleLinkedNode firstHeadNode = this.mSingleLinkedListFirst.getHeadNode();
    SingleLinkedNode secondHeadNode = this.mSingleLinkedListSecond.getHeadNode();
    SingleLinkedNode newHeadNode =
        SingleLinkedList.mergeTwoLists(firstHeadNode.next, secondHeadNode.next);
    _validMergeListsResult(newHeadNode);
    //    System.out.printf("\n");
  }

  @Test
  public void testMergeTwoListsSimpleLoopImp() {
    SingleLinkedNode firstHeadNode = this.mSingleLinkedListFirst.getHeadNode();
    SingleLinkedNode secondHeadNode = this.mSingleLinkedListSecond.getHeadNode();
    SingleLinkedNode newHeadNode =
        SingleLinkedList.mergeTwoListsSimpleLoopImpl(firstHeadNode.next, secondHeadNode.next);
    _validMergeListsResult(newHeadNode);
  }

  private void _validMergeListsResult(SingleLinkedNode newHeadNode) {
    Assert.assertNotNull(newHeadNode);
    //    Assert.assertEquals(1, newHeadNode.getValue());
    //    SingleLinkedNode newNode1 = newHeadNode.getNext();
    //    Assert.assertNotNull(newNode1);
    //    Assert.assertEquals(1, newNode1.getValue());
    //    SingleLinkedNode newNode2 = newNode1.getNext();
    //    Assert.assertNotNull(newNode2);
    //    Assert.assertEquals(2, newNode2.getValue();

    int[] expectedValue = {1, 1, 2, 3, 4, 4};
    SingleLinkedNode itNode = newHeadNode;
    int loopIndex = 0;
    while (itNode != null) {
      Assert.assertNotNull(itNode);
      Assert.assertEquals(expectedValue[loopIndex], itNode.getValue());
      //      System.out.printf("index[%d] = %d --> ", loopIndex, itNode.getValue());
      itNode = itNode.getNext();
      loopIndex++;
    }
    //    System.out.printf("\n");
  }

  @Test
  public void testMergeKLists() {
    SingleLinkedNode firstHeadNode = this.mSingleLinkedListFirst.getHeadNode();
    SingleLinkedNode secondHeadNode = this.mSingleLinkedListSecond.getHeadNode();
    SingleLinkedNode[] lists = {firstHeadNode.next, secondHeadNode.next};

    SingleLinkedNode newHeadNode = SingleLinkedList.mergeKLists(lists);
    _validMergeListsResult(newHeadNode);
  }
}
