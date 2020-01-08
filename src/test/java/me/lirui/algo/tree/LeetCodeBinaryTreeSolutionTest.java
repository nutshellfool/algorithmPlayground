package me.lirui.algo.tree;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeBinaryTreeSolutionTest {

  private LeetCodeBinaryTreeSolution mSolution;
  private BinarySearchTree mTree;

  @Before
  public void setUp() {
    mSolution = new LeetCodeBinaryTreeSolution();
    mTree = new BinarySearchTree();

    // build a BST like this:
    //
    //          2
    //         / \
    //        1   4
    //           / \
    //          3   5

    // construct the tree.
    mTree.addTreeNode(2);
    mTree.addTreeNode(1);
    mTree.addTreeNode(4);
    mTree.addTreeNode(3);
    mTree.addTreeNode(5);
  }

  @After
  public void tearDown() {}

  @Test
  public void levelOrder() {
    List<List<Integer>> orderList = mSolution.levelOrder(mTree.root);
    Assert.assertNotNull(orderList);
    Assert.assertEquals(3, orderList.size());
    Assert.assertEquals(1, orderList.get(0).size());
    Assert.assertEquals(2, orderList.get(0).get(0));
    Assert.assertEquals(2, orderList.get(1).size());
    Assert.assertEquals(1, orderList.get(1).get(0));
    Assert.assertEquals(4, orderList.get(1).get(1));
    Assert.assertEquals(2, orderList.get(2).size());
    Assert.assertEquals(3, orderList.get(2).get(0));
    Assert.assertEquals(5, orderList.get(2).get(1));
  }

  @Test
  public void levelOrderDFS() {
    List<List<Integer>> orderList = mSolution.levelOrderDFS(mTree.root);
    Assert.assertNotNull(orderList);
    Assert.assertEquals(3, orderList.size());
    Assert.assertEquals(1, orderList.get(0).size());
    Assert.assertEquals(2, orderList.get(0).get(0));
    Assert.assertEquals(2, orderList.get(1).size());
    Assert.assertEquals(1, orderList.get(1).get(0));
    Assert.assertEquals(4, orderList.get(1).get(1));
    Assert.assertEquals(2, orderList.get(2).size());
    Assert.assertEquals(3, orderList.get(2).get(0));
    Assert.assertEquals(5, orderList.get(2).get(1));
  }

  @Test
  public void maxDepth() {}
}