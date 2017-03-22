package test.me.lirui.algo.tree; 

import me.lirui.algo.tree.BinarySearchTree;
import me.lirui.algo.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BinarySearchTree Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 21, 2017</pre> 
* @version 1.0 
*/ 
public class BinarySearchTreeTest {
    private BinarySearchTree mTree;

@Before
public void before() throws Exception {
    if (mTree == null){
        mTree = new BinarySearchTree();

        // do some basic construct job
        for (int i = 1; i < 5; i++) {
            mTree.addTreeNode(i);
        }
    }
} 

@After
public void after() throws Exception {
    mTree = null;
} 

/** 
* 
* Method: addTreeNode(int value) 
* 
*/ 
@Test
public void testAddNotExistedTreeNode() throws Exception {
    TreeNode theAddedNode = mTree.addTreeNode(6);
    Assert.assertNotNull(theAddedNode);
}

/**
 *
 * Method: addTreeNode(int value)
 *
 */
@Test
public void testAddExistedTreeNode() throws Exception {
    TreeNode theAddedNode = mTree.addTreeNode(3);
    Assert.assertNotNull(theAddedNode);
}

/**
* 
* Method: searchNode(int value) 
* 
*/ 
@Test
public void testSearchExistedNode() throws Exception {
    mTree.addTreeNode(3);
    TreeNode foundedTreeNode = mTree.searchNode(3);
    Assert.assertNotNull(foundedTreeNode);
}

/**
 *
 * Method: searchNode(int value)
 *
 */
@Test
public void testSearchNotExistedNode() throws Exception {
    TreeNode foundedTreeNode = mTree.searchNode(7);
    Assert.assertNull(foundedTreeNode);
}

/** 
* 
* Method: deleteNode(int value) 
* 
*/ 
@Test
public void testDeleteMinNode() throws Exception {
    TreeNode deletedNode = mTree.deleteNode(1);
    Assert.assertNotNull(deletedNode);
    Assert.assertEquals(deletedNode.getData(), 2);
}


// About the delete operation, we should consider these 4 cases:
//  1. if the node is leaf
//  2. if the node has left child, but no right child
//  3. if the node has right child, but no left child
//  4. if the node both has right child and left child.
//

/**
 * Method: deleteNode(int value)
 *
 * @throws Exception
 */
@Test
public void testDeleteNodeCase1() throws Exception {
    // build a simple BST like this:
    //
    //          2
    //         / \
    //        1   3

    // construct the tree.
    mTree.clear();
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(3);

    TreeNode theSubstuitionNode = mTree.deleteNode(1);
    Assert.assertNotNull(theSubstuitionNode);
    Assert.assertEquals(2, theSubstuitionNode.getData());
    Assert.assertNull(theSubstuitionNode.getLeftChild());
}

/**
 *
 * Method: deleteNode(int value)
 * @throws Exception
 */
@Test
public void testDeleteNodeCase2() throws Exception {
    // build a BST like this:
    //
    //          2
    //         / \
    //        1   4
    //           /
    //          3

    // construct the tree.
    mTree.clear();
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(4);
    mTree.addTreeNode(3);

    TreeNode theSubstuitionNode = mTree.deleteNode(4);
    //
    //          2
    //         / \
    //        1   3
    //
    Assert.assertNotNull(theSubstuitionNode);
    Assert.assertEquals(2, theSubstuitionNode.getData());
}


/**
 *
 * Method: deleteNode(int value)
 * @throws Exception
 */
@Test
public void testDeleteNodeCase3() throws Exception {
    // build a BST like this:
    //
    //          2
    //         / \
    //        1   3
    //             \
    //              4

    // construct the tree.
    mTree.clear();
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(3);
    mTree.addTreeNode(4);

    TreeNode theSubstuitionNode = mTree.deleteNode(3);

    //          2
    //         / \
    //        1   4
    //
    Assert.assertNotNull(theSubstuitionNode);
    Assert.assertEquals(2, theSubstuitionNode.getData());
    Assert.assertEquals(4, theSubstuitionNode.getRightChild().getData());
    Assert.assertEquals(1,theSubstuitionNode.getLeftChild().getData());
}

/**
 *
 * Method: deleteNode(int value)
 * @throws Exception
 */
@Test
public void testDeleteNodeCase4() throws Exception {
    // build a BST like this:
    //
    //          2
    //         / \
    //        1   4
    //           / \
    //          3   5

    // construct the tree.
    mTree.clear();
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(4);
    mTree.addTreeNode(3);
    mTree.addTreeNode(5);

    TreeNode theSubstuitionNode = mTree.deleteNode(4);

    //
    //          2
    //         / \
    //        1   5
    //           /
    //          3
    Assert.assertNotNull(theSubstuitionNode);
    Assert.assertEquals(2, theSubstuitionNode.getData());
    Assert.assertEquals(1,theSubstuitionNode.getLeftChild().getData());
    Assert.assertEquals(5,theSubstuitionNode.getRightChild().getData());
    Assert.assertEquals(3, theSubstuitionNode.getRightChild().getLeftChild().getData());
}

} 
