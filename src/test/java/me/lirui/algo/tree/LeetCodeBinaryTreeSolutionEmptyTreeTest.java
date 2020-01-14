package me.lirui.algo.tree;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeBinaryTreeSolutionEmptyTreeTest {

  private LeetCodeBinaryTreeSolution mSolution;
  private BinarySearchTree mTree;

  @Before
  public void setUp() {
    mSolution = new LeetCodeBinaryTreeSolution();
    mTree = new BinarySearchTree();
  }

  @Test
  public void levelOrder() {
    List<List<Integer>> orderList = mSolution.levelOrder(mTree.root);
    Assert.assertNotNull(orderList);
    Assert.assertEquals(0, orderList.size());
  }

  @Test
  public void levelOrderDFS() {
    List<List<Integer>> orderList = mSolution.levelOrderDFS(mTree.root);
    Assert.assertNotNull(orderList);
    Assert.assertEquals(0, orderList.size());
  }

  @Test
  public void maxDepth() {
    int maxDepth = mSolution.maxDepth(mTree.root);
    Assert.assertEquals(0, maxDepth);
  }

  @Test
  public void maxDepthBFS() {
    int maxDepth = mSolution.maxDepthBFS(mTree.root);
    Assert.assertEquals(0, maxDepth);
  }

  @Test
  public void maxDepthDFS() {
    int maxDepth = mSolution.maxDepthDFS(mTree.root);
    Assert.assertEquals(0, maxDepth);
  }

  @Test
  public void minDepth() {
    int minDepth = mSolution.minDepth(mTree.root);
    Assert.assertEquals(0, minDepth);
  }

  @Test
  public void minDepthBFS() {
    int minDepth = mSolution.minDepthBFS(mTree.root);
    Assert.assertEquals(0, minDepth);
  }

  @Test
  public void minDepthDFS() {
    int minDepth = mSolution.minDepthDFS(mTree.root);
    Assert.assertEquals(0, minDepth);
  }
}
