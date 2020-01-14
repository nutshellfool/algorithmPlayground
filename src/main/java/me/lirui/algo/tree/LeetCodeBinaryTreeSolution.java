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

  int maxDepthBFS(TreeNode root) {
    if (root == null) return 0;

    int minDepth = 0, maxDepth = 0;
    int currentDepth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      currentDepth++;
      int batchSize = queue.size();
      for (int i = 0; i < batchSize; i++) {
        TreeNode node = queue.poll();
        if (node.leftChild == null && node.rightChild == null) {
          minDepth = Math.min(minDepth, currentDepth);
          maxDepth = Math.max(maxDepth, currentDepth);
        }

        if (node.leftChild != null) queue.offer(node.leftChild);
        if (node.rightChild != null) queue.offer(node.rightChild);
      }
    }
    return maxDepth;
  }

  int maxDepthDFS(TreeNode root) {
    if (root == null) return 0;
    int[] result = new int[1];
    _dfs(root, 0, result);
    return result[0];
  }

  private void _dfs(TreeNode root, int level, int[] result) {
    if (root == null) return;

    if (root.leftChild == null && root.rightChild == null) {
      result[0] = Math.max(result[0], level + 1);
    }
    _dfs(root.leftChild, level + 1, result);
    _dfs(root.rightChild, level + 1, result);
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

  int minDepthBFS(TreeNode root) {
    if (root == null) return 0;

    int currentDepth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      currentDepth++;
      int batchSize = queue.size();
      for (int i = 0; i < batchSize; i++) {
        TreeNode node = queue.poll();
        if (node.leftChild == null && node.rightChild == null) return currentDepth;

        if (node.leftChild != null) queue.offer(node.leftChild);
        if (node.rightChild != null) queue.offer(node.rightChild);
      }
    }

    return 0;
  }

  int minDepthDFS(TreeNode root) {
    if (root == null) return 0;

    int[] result = new int[1];
    _dfsMin(root, 0, result);
    return result[0];
  }

  private void _dfsMin(TreeNode root, int level, int[] result) {
    if (root == null) return;
    if (root.leftChild == null && root.rightChild == null) {
      result[0] = result[0] == 0 ? level + 1 : Math.min(result[0], level + 1);
    }
    _dfsMin(root.leftChild, level + 1, result);
    _dfsMin(root.rightChild, level + 1, result);
  }
  //
  //  Minimum Depth of Binary Tree -
  // https://leetcode.com/problems/minimum-depth-of-binary-tree/
  //  End

}
