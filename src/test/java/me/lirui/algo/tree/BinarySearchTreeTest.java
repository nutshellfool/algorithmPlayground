package me.lirui.algo.tree;

import me.lirui.algo.tree.BinarySearchTree;
import me.lirui.algo.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* BinarySearchTree Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 11, 2017</pre>
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
    // TODO: the construct way may have opt space, refactoring it!
    mTree.clear();
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(3);

    TreeNode theNode = mTree.deleteNode(1);
    Assert.assertNotNull(theNode);
    Assert.assertEquals(2, theNode.getData());
    Assert.assertNull(theNode.getLeftChild());
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

    TreeNode node = mTree.deleteNode(4);
    //
    //          2
    //         / \
    //        1   3
    //
    Assert.assertNotNull(node);
    Assert.assertEquals(2, node.getData());
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

    TreeNode node = mTree.deleteNode(3);

    //          2
    //         / \
    //        1   4
    //
    Assert.assertNotNull(node);
    Assert.assertEquals(2, node.getData());
    Assert.assertEquals(4, node.getRightChild().getData());
    Assert.assertEquals(1,node.getLeftChild().getData());
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

    TreeNode node = mTree.deleteNode(4);

    //
    //          2
    //         / \
    //        1   5
    //           /
    //          3
    Assert.assertNotNull(node);
    Assert.assertEquals(2, node.getData());
    Assert.assertEquals(1,node.getLeftChild().getData());
    Assert.assertEquals(5,node.getRightChild().getData());
    Assert.assertEquals(3, node.getRightChild().getLeftChild().getData());
}

    @Test
    public void testTheInorderTraversalOrderList() throws Exception {
        mTree.clear();
        mTree.addTreeNode(2);
        mTree.addTreeNode(1);
        mTree.addTreeNode(3);

        ArrayList<Integer> theInOutArray = new ArrayList<Integer>();
        mTree.theInorderTraversalOrderList(theInOutArray);

        Assert.assertNotNull(theInOutArray);
        Assert.assertEquals(3, theInOutArray.size());
        Assert.assertEquals(1, theInOutArray.get(0));
        Assert.assertEquals(2, theInOutArray.get(1));
        Assert.assertEquals(3, theInOutArray.get(2));
    }

    @Test
    public void testThePreOrderTraversalOrderList() throws Exception {
        mTree.clear();
        mTree.addTreeNode(2);
        mTree.addTreeNode(1);
        mTree.addTreeNode(3);

        ArrayList<Integer> theInOutArray = new ArrayList<Integer>();
        mTree.thePreOrderTraversalOrderList(theInOutArray);

        Assert.assertNotNull(theInOutArray);
        Assert.assertEquals(3, theInOutArray.size());
        Assert.assertEquals(2, theInOutArray.get(0));
        Assert.assertEquals(1, theInOutArray.get(1));
        Assert.assertEquals(3, theInOutArray.get(2));
    }

    @Test
    public void testThePostOrderTraversalOrderList() throws Exception {
        mTree.clear();
        mTree.addTreeNode(2);
        mTree.addTreeNode(1);
        mTree.addTreeNode(3);

        ArrayList<Integer> theInOutArray = new ArrayList<Integer>();
        mTree.thePostOrderTraversalOrderList(theInOutArray);

        Assert.assertNotNull(theInOutArray);
        Assert.assertEquals(3, theInOutArray.size());
        Assert.assertEquals(1, theInOutArray.get(0));
        Assert.assertEquals(3, theInOutArray.get(1));
        Assert.assertEquals(2, theInOutArray.get(2));
    }

    @Test
    public void testIsValidInHappyCase() throws Exception {
        mTree.clear();
        mTree.addTreeNode(2);
        mTree.addTreeNode(1);
        mTree.addTreeNode(3);

        boolean isValidInRecurrence = mTree.isValid(true);
        boolean isValidInNoRecurrence = mTree.isValid(false);

        Assert.assertEquals(true, isValidInRecurrence);
        Assert.assertEquals(true, isValidInNoRecurrence);
    }

    @Test
    public void testIsValidInOtherCase() throws Exception {
        mTree.clear();
        mTree.addTreeNode(2);
        mTree.addTreeNodeInNoBSTWay(1);
        mTree.addTreeNodeInNoBSTWay(3);

        boolean isValidInRecurrence = mTree.isValid(true);
        boolean isValidInNoRecurrence = mTree.isValid(false);

        Assert.assertEquals(false, isValidInRecurrence);
        Assert.assertEquals(false, isValidInNoRecurrence);
    }


    @Test
    public void testBFS() throws Exception {
        generateCompleteBinarySearchTree(mTree);

        ArrayList<Integer> result = new ArrayList<Integer>();
        mTree.breathFirstSearch(result);
        Assert.assertEquals(result.get(0), 3);
        Assert.assertEquals(result.get(1), 1);
        Assert.assertEquals(result.get(2), 5);
    }

    @Test
    public void testDFS() throws Exception {
        generateCompleteBinarySearchTree(mTree);
        ArrayList<Integer> result = new ArrayList<Integer>();
        mTree.depthFirstSearch(result);
        Assert.assertEquals(result.get(0), 3);
        Assert.assertEquals(result.get(1), 5);
        Assert.assertEquals(result.get(2), 6);
    }

    @Test
    public void testWFS() throws Exception {
        generateCompleteBinarySearchTree(mTree);
        ArrayList<Integer> result = new ArrayList<Integer>();
        mTree.weightFirstSearch(result);
        Assert.assertEquals(result.get(0), 3);
        Assert.assertEquals(result.get(1), 5);
        Assert.assertEquals(result.get(2), 6);
        Assert.assertEquals(result.get(3), 4);
        Assert.assertEquals(result.get(4), 1);
        Assert.assertEquals(result.get(5), 2);
        Assert.assertEquals(result.get(6), 0);
    }

    private void generateCompleteBinarySearchTree(BinarySearchTree tree) {
        tree.clear();
        tree.addTreeNode(3);
        tree.addTreeNode(1);
        tree.addTreeNode(5);
        tree.addTreeNode(0);
        tree.addTreeNode(2);
        tree.addTreeNode(4);
        tree.addTreeNode(6);
    }
}
