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
  public void maxDepth() {}
}
