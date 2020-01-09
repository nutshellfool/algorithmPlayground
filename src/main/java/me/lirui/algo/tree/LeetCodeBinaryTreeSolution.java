package me.lirui.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class LeetCodeBinaryTreeSolution {

  //
  //  Binary Tree Level Order Traversal -
  // https://leetcode.com/problems/binary-tree-level-order-traversal/
  //
  List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      List<Integer> listItem = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        listItem.add(Objects.requireNonNull(node).data);

        TreeNode left = node.leftChild;
        TreeNode right = node.rightChild;
        if (left != null) queue.offer(left);
        if (right != null) queue.offer(right);
      }
      result.add(listItem);
    }

    return result;
  }

  List<List<Integer>> levelOrderDFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    dfsLevelOrder(root, result, 0);
    return result;
  }

  private void dfsLevelOrder(TreeNode node, List<List<Integer>> outputResult, int level) {
    if (node == null) return;

    if (outputResult.size() < level + 1) {
      outputResult.add(new ArrayList<Integer>());
    }

    outputResult.get(level).add(node.data);

    dfsLevelOrder(node.leftChild, outputResult, level + 1);
    dfsLevelOrder(node.rightChild, outputResult, level + 1);
  }

  //
  //  Binary Tree Level Order Traversal -
  // https://leetcode.com/problems/binary-tree-level-order-traversal/
  //  End

  //
  //  Maximum Depth of Binary Tree -
  // https://leetcode.com/problems/maximum-depth-of-binary-tree/
  //
  int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild)) + 1;
  }
  //
  //  Maximum Depth of Binary Tree -
  // https://leetcode.com/problems/maximum-depth-of-binary-tree/
  //  End

  //
  //  Minimum Depth of Binary Tree -
  // https://leetcode.com/problems/minimum-depth-of-binary-tree/
  //
  int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.leftChild == null) return minDepth(root.rightChild) + 1;
    if (root.rightChild == null) return minDepth(root.leftChild) + 1;

    return Math.min(minDepth(root.leftChild), minDepth(root.rightChild)) + 1;
  }
  //
  //  Minimum Depth of Binary Tree -
  // https://leetcode.com/problems/minimum-depth-of-binary-tree/
  //  End

}
