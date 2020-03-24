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
  public void tearDown() {
  }

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
  public void maxDepth() {
    int maxDepth = mSolution.maxDepth(mTree.root);
    Assert.assertEquals(3, maxDepth);
  }

  @Test
  public void maxDepthBFS() {
    int maxDepth = mSolution.maxDepthBFS(mTree.root);
    Assert.assertEquals(3, maxDepth);
  }

  @Test
  public void maxDepthDFS() {
    int maxDepth = mSolution.maxDepthDFS(mTree.root);
    Assert.assertEquals(3, maxDepth);
  }

  @Test
  public void minDepth() {
    int minDepth = mSolution.minDepth(mTree.root);
    Assert.assertEquals(2, minDepth);
  }

  @Test
  public void minDepthBFS() {
    int minDepth = mSolution.minDepthBFS(mTree.root);
    Assert.assertEquals(2, minDepth);
  }

  @Test
  public void minDepthDFS() {
    int minDepth = mSolution.minDepthDFS(mTree.root);
    Assert.assertEquals(2, minDepth);
  }

  @Test
  public void lowestCommonAncestor() {
    TreeNode lca = mSolution
        .lowestCommonAncestor(mTree.root, mTree.root.leftChild, mTree.root.rightChild);
    Assert.assertNotNull(lca);
    Assert.assertEquals(2, mTree.root.data);
  }

  @Test
  public void lowestCommonAncestorBST() {
    TreeNode lca = mSolution
        .lowestCommonAncestorBST(mTree.root, mTree.root.leftChild, mTree.root.rightChild);
    Assert.assertNotNull(lca);
    Assert.assertEquals(2, mTree.root.data);
  }

  @Test
  public void inorderTraversal() {
    List<Integer> traversalList = mSolution.inorderTraversal(mTree.root);
    Assert.assertNotNull(traversalList);
    Assert.assertEquals(5, traversalList.size());
    for (int i = 0 ; i < traversalList.size(); i++) {
      Assert.assertEquals(i + 1, traversalList.get(i));
    }
  }

  @Test
  public void inorderTraversalIteration() {
    List<Integer> traversalList = mSolution.inorderTraversalIteration(mTree.root);
    Assert.assertNotNull(traversalList);
    Assert.assertEquals(5, traversalList.size());
    for (int i = 0 ; i < traversalList.size(); i++) {
      Assert.assertEquals(i + 1, traversalList.get(i));
    }
  }

  @Test
  public void preOrderTraversal() {
    List<Integer> traversalList = mSolution.preOrderTraversal(mTree.root.rightChild);
    Assert.assertNotNull(traversalList);
    Assert.assertEquals(3, traversalList.size());
    Assert.assertEquals(4, traversalList.get(0));
    Assert.assertEquals(3, traversalList.get(1));
    Assert.assertEquals(5, traversalList.get(2));
  }

  @Test
  public void preOrderTraversalIteration() {
    List<Integer> traversalList = mSolution.preOrderTraversalIteration(mTree.root.rightChild);
    Assert.assertNotNull(traversalList);
    Assert.assertEquals(3, traversalList.size());
    Assert.assertEquals(4, traversalList.get(0));
    Assert.assertEquals(3, traversalList.get(1));
    Assert.assertEquals(5, traversalList.get(2));
  }
}
