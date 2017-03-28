package test.me.lirui.algo.linkedlist; 

import me.lirui.algo.linkedlist.SingleLinkedList;
import me.lirui.algo.linkedlist.SingleLinkedNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SingleLinkedList Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 21, 2017</pre>
* @version 1.0 
*/ 
public class SingleLinkedListTest { 

    private SingleLinkedList mSingleLinkedList;

@Before
public void before() throws Exception {
    this.mSingleLinkedList = new SingleLinkedList();
    mSingleLinkedList.appendNodeToTail(1);
    mSingleLinkedList.appendNodeToTail(2);
    mSingleLinkedList.appendNodeToTail(3);
} 

@After
public void after() throws Exception {
    this.mSingleLinkedList.clearList();
} 

/** 
* 
* Method: getHeadNode() 
* 
*/ 
@Test
public void testGetHeadNode() throws Exception {
    SingleLinkedNode headNode = mSingleLinkedList.getHeadNode();
    Assert.assertNotNull(headNode);
}

/** 
* 
* Method: appendNodeToTail(int value) 
* 
*/ 
@Test
public void testAppendNodeToTail() throws Exception {
    mSingleLinkedList.appendNodeToTail(4);
    Assert.assertEquals(4, mSingleLinkedList.getSize());
}

/** 
* 
* Method: searchNode(int value) 
* 
*/ 
@Test
public void testSearchNodeExisted() throws Exception {
    SingleLinkedNode foundNode = mSingleLinkedList.searchNode(2);
    Assert.assertNotNull(foundNode);
    Assert.assertEquals(2,foundNode.getValue());
    Assert.assertNotNull(foundNode.getNext());
    Assert.assertEquals(3, foundNode.getNext().getValue());
}

/**
 *
 * Method: searchNode(int value)
 *
 */
@Test
public void testSearchNodeNotExisted() throws Exception {
    SingleLinkedNode foundNode = mSingleLinkedList.searchNode(6);
    Assert.assertNull(foundNode);
}

/** 
* 
* Method: deleteNode(int value) 
* 
*/ 
@Test
public void testDeleteNode1stNode() throws Exception {
    mSingleLinkedList.deleteNode(1);
    Assert.assertEquals(2, mSingleLinkedList.getSize());
    Assert.assertNotNull(mSingleLinkedList.getHeadNode());
    Assert.assertEquals(2,mSingleLinkedList.getHeadNode().getNext().getValue());
}

/**
 *
 * Method: deleteNode(int value)
 *
 */
@Test
public void testDeleteNodeLastNode() throws Exception {
    mSingleLinkedList.deleteNode(3);
    Assert.assertEquals(2, mSingleLinkedList.getSize());
    Assert.assertNotNull(mSingleLinkedList.searchNode(2));
    Assert.assertNull(mSingleLinkedList.searchNode(2).getNext());
}
}
