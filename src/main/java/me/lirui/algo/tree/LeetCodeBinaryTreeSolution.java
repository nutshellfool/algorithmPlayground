package me.lirui.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

class LeetCodeBinaryTreeSolution {

  //
  //  Binary Tree Level Order Traversal -
  // https://leetcode.com/problems/binary-tree-level-order-traversal/
  //
  List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
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
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
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
    if (node == null) {
      return;
    }

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
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild)) + 1;
  }

  int maxDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

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

        if (node.leftChild != null) {
          queue.offer(node.leftChild);
        }
        if (node.rightChild != null) {
          queue.offer(node.rightChild);
        }
      }
    }
    return maxDepth;
  }

  int maxDepthDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] result = new int[1];
    _dfs(root, 0, result);
    return result[0];
  }

  private void _dfs(TreeNode root, int level, int[] result) {
    if (root == null) {
      return;
    }

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
    if (root == null) {
      return 0;
    }
    if (root.leftChild == null) {
      return minDepth(root.rightChild) + 1;
    }
    if (root.rightChild == null) {
      return minDepth(root.leftChild) + 1;
    }

    return Math.min(minDepth(root.leftChild), minDepth(root.rightChild)) + 1;
  }

  int minDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int currentDepth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      currentDepth++;
      int batchSize = queue.size();
      for (int i = 0; i < batchSize; i++) {
        TreeNode node = queue.poll();
        if (node.leftChild == null && node.rightChild == null) {
          return currentDepth;
        }

        if (node.leftChild != null) {
          queue.offer(node.leftChild);
        }
        if (node.rightChild != null) {
          queue.offer(node.rightChild);
        }
      }
    }

    return 0;
  }

  int minDepthDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int[] result = new int[1];
    _dfsMin(root, 0, result);
    return result[0];
  }

  private void _dfsMin(TreeNode root, int level, int[] result) {
    if (root == null) {
      return;
    }
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

  //
  // Lowest Common Ancestor of a Binary Tree
  // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.leftChild, p, q);
    TreeNode right = lowestCommonAncestor(root.rightChild, p, q);

    return left == null ? right : right == null ? left : root;
  }
  //
  // Lowest Common Ancestor of a Binary Tree
  // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  // End

  //
  //  Lowest Common Ancestor of a Binary Search Tree
  //  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
  TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
    if (root.data < p.data && root.data < q.data) {
      return lowestCommonAncestorBST(root.rightChild, p, q);
    } else if (root.data > p.data && root.data > q.data) {
      return lowestCommonAncestorBST(root.leftChild, p, q);
    }
    return root;
  }
  //  Lowest Common Ancestor of a Binary Search Tree
  //  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
  // End

  // Binary Tree Inorder Traversal
  // https://leetcode.com/problems/binary-tree-inorder-traversal/
  List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    _treeInorderTraversal(root, result);
    return result;
  }

  private void _treeInorderTraversal(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }

    _treeInorderTraversal(root.leftChild, result);
    result.add(root.data);
    _treeInorderTraversal(root.rightChild, result);
  }

  List<Integer> inorderTraversalIteration(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (!stack.isEmpty() || current != null) {
      while (current != null) {
        stack.add(current);
        current = current.leftChild;
      }

      current = stack.pop();
      result.add(current.data);
      current = current.rightChild;
    }

    return result;
  }
  // Binary Tree Inorder Traversal
  // https://leetcode.com/problems/binary-tree-inorder-traversal/
  // End

  // Binary Tree Preorder Traversal
  // https://leetcode.com/problems/binary-tree-preorder-traversal/
  List<Integer> preOrderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    _treePreOrderTraversal(root, result);
    return result;
  }


  private void _treePreOrderTraversal(TreeNode node, ArrayList<Integer> result) {
    if (node == null) {
      return;
    }

    result.add(node.data);
    _treePreOrderTraversal(node.leftChild, result);
    _treeInorderTraversal(node.rightChild, result);
  }

  List<Integer> preOrderTraversalIteration(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        result.add(node.data);
        stack.push(node.rightChild);
        stack.push(node.leftChild);
      }
    }
    return result;
  }
  // Binary Tree Preorder Traversal
  // https://leetcode.com/problems/binary-tree-preorder-traversal/
  // End

  // Binary Tree Postorder Traversal
  // https://leetcode.com/problems/binary-tree-postorder-traversal/
  List<Integer> postOrderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    _treePostOrderTraversal(root, result);
    return result;
  }

  private void _treePostOrderTraversal(TreeNode node, ArrayList<Integer> result) {
    if (node == null) {
      return;
    }
    _treePostOrderTraversal(node.leftChild, result);
    _treePostOrderTraversal(node.rightChild, result);
    result.add(node.data);
  }

  List<Integer> postOrderTraversalIteration(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        result.add(node.data);
        stack.push(node.leftChild);
        stack.push(node.rightChild);
      }
    }

    Collections.reverse(result);
    return result;
  }
  // Binary Tree Postorder Traversal
  // https://leetcode.com/problems/binary-tree-postorder-traversal/
  // End
}
