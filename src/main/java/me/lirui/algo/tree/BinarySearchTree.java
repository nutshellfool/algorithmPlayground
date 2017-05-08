package me.lirui.algo.tree;

import org.junit.Assert;

import java.util.*;

/**
 * Created by RichardLee on 2017/3/11.
 */
public class BinarySearchTree {
    // root node
    TreeNode root;

    // Do nothing
    public BinarySearchTree() {
    }


    public void clear() {
        this.root = null;
    }

    /**
     *  Add the node
     *
     * @param value
     * @return
     */
    public TreeNode addTreeNode(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        }

        return addTreeNode(true, this.root, value);
    }

    public TreeNode addTreeNodeInNoBSTWay(int value) {
        return addTreeNode(false, this.root, value);
    }

    private  TreeNode addTreeNode(TreeNode root, int value) {
        return addTreeNode(true, root, value);
    }

    private TreeNode addTreeNode(boolean isBST, TreeNode root, int value) {
        if (root == null){
            return new TreeNode(value);
        }

        int valueOfRootElement = root.data;
        if (value < valueOfRootElement){
            if (isBST) {
                root.leftChild = addTreeNode(root.leftChild, value);
            } else {
                root.rightChild = addTreeNode(root.rightChild, value);
            }
        }else if (value > valueOfRootElement){
            if (isBST) {
                root.rightChild = addTreeNode(root.rightChild, value);
            } else {
                root.leftChild = addTreeNode(root.leftChild, value);
            }
        }else {
            root.data = value;
        }

        return root;
    }


    /**
     *
     * Search the Node by its value
     *
     * @param value
     * @return
     */
    public TreeNode searchNode(int value){
        return searchNode(this.root, value);
    }

    private TreeNode searchNode(TreeNode root, int value) {
        // empty tree
        if (root == null){
            return null;
        }

        // in order travels
        int rootValue = root.data;
        if (value < rootValue) {
            return searchNode(root.leftChild, value);
        } else if (value > rootValue) {
            return searchNode(root.rightChild, value);
        }

        return root;
    }

    /**
     *
     * Delete the node by its value
     *
     * @param value
     * @return
     */
    public TreeNode deleteNode(int value) {
        return deleteNode(this.root, value);
    }

    private  TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        int rootValue = root.data;
        if (value < rootValue) {
            root.leftChild = deleteNode(root.leftChild, value);
        } else if (value > rootValue) {
            root.rightChild = deleteNode(root.rightChild, value);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            }

            if (root.rightChild == null) {
                return  root.leftChild;
            }

            // search for the min node in right child subtree,
            // and then replace the current node.
            //
            TreeNode newRootNode = findMin(root.rightChild);
            // replace the current node.
            root.data = newRootNode.data;
            // remove from the previous right subtree
            root.rightChild = deleteNode(root.rightChild, newRootNode.data);
        }

       return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null){
            return  null;
        }
        TreeNode leftNode = node.leftChild;
        return leftNode == null ?
                node: findMin(leftNode.leftChild);
    }

    /**
     *
     *  Judge the BST is valid
     *
     * @param isRecurrenceVersion
     * @return
     */
    public boolean isValid(boolean isRecurrenceVersion) {
        return isRecurrenceVersion ? isValid(this.root, Long.MAX_VALUE, Long.MIN_VALUE) : isValidInNoRecurrenceVersion();
    }

    /**
     *  Judge the tree is valid (recurrence version)
     *
     *  Time and space Analysis:
     *      1. the time complexity:
     *          because the first 2 lines is constants complexity(O(1))
     *          the last return line turn the problem into 2 part sub-problems
     *          so use the Big-Oh additional rule, we got the
     *          T(n) = 2*O(1) + O(n/2) + O(n/2) = 2O(n/2) + 2*O(1)
     *          therefore we get conclusion:
     *          the time complexity is O(lgn)
     *
     *      2. space complexity:
     *          no more auxiliary space for this algorithm
     *
     * @param node  rootVersion
     * @param max   maxValue in tree
     * @param min   minValue in tree
     * @return
     */
    private boolean isValid(TreeNode node, long max, long min) {
        if (node == null) return true;

        if (node.data >= max || node.data <= min) return false;

        return isValid(node.leftChild, node.data, min) && isValid(node.rightChild, max, node.data);
    }

    /**
     *  Judge the tree is valid (no recurrence version)
     *
     *  Time and space Analysis:
     *
     *      1. the time complexity
     *          first the code structure is not recurrence structure, and in a continue flow,
     *          so it's ok to apply the Big-Oh additional rule.
     *          first part is the tree inorder traversal complexity, time complexity is (O(n))
     *          second part is also the traversal complexity, at least time complexity is (O(n))
     *
     *          therefore the time complexity is T(n) = O(n) +O(n)
     *          we get the conclusion :
     *              O(n)
     *
     *      2. the space complexity
     *          auxiliary space is used: an N length array
     *
     * @return
     */
    private boolean isValidInNoRecurrenceVersion() {
        // Basic Idea is
        // 1. convert the tree to the array
        // 2. judge the array is in right order?
        if (this.root == null) return true;

        ArrayList<Integer> theOrderList = new ArrayList<Integer>();
        theInorderTraversalOrderList(theOrderList);

        // judge the array in the right order(ascend order)

        return isArraySortedInAscendOrder(theOrderList);
    }


    public boolean isArraySortedInAscendOrder(ArrayList<Integer> list) {
        if (list == null || list.size() <= 1) return true;

        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            if (list.get(i) > list.get(i+1)){
                return false;
            }
        }

        return true;
    }

    /**
     *
     * Traversal the tree with the Inorder way
     *
     * @param theInOutList
     */
    public void theInorderTraversalOrderList(ArrayList<Integer> theInOutList) {

        _inOrderTraversal(this.root, theInOutList);
    }

    private void _inOrderTraversal(TreeNode node, ArrayList<Integer> theInOutList) {
        Assert.assertNotNull(theInOutList);

        if (node == null) return;

        // first get traversal the left node.
        _inOrderTraversal(node.leftChild, theInOutList);
        theInOutList.add(node.data);
        _inOrderTraversal(node.rightChild, theInOutList);

    }

    /**
     *  Traversal the tree with the preorder way
     *
     * @param thePreOrderList
     */
    public void thePreOrderTraversalOrderList(ArrayList<Integer> thePreOrderList) {
        Assert.assertNotNull(thePreOrderList);
        _preOrderTraversal(this.root, thePreOrderList);
    }

    private void _preOrderTraversal(TreeNode node, ArrayList<Integer> theInOutList) {
        Assert.assertNotNull(theInOutList);

        if (node == null) return;

        theInOutList.add(node.data);
        _preOrderTraversal(node.leftChild, theInOutList);
        _preOrderTraversal(node.rightChild, theInOutList);
    }

    /**
     * Traversal the tree with the postorder way
     *
     * @param theInOutList
     */
    public void thePostOrderTraversalOrderList(ArrayList<Integer> theInOutList) {
        Assert.assertNotNull(theInOutList);
        _postOrderTraversal(this.root, theInOutList);
    }

    private void _postOrderTraversal(TreeNode node, ArrayList<Integer> theInOutList) {
        Assert.assertNotNull(theInOutList);

        if (node == null) return;

        _postOrderTraversal(node.leftChild, theInOutList);
        _postOrderTraversal(node.rightChild, theInOutList);
        theInOutList.add(node.data);
    }

    /**
     * BFS the Binary Search Tree.
     *
     * @param inOutList
     */
    public void breathFirstSearch(ArrayList<Integer> inOutList) {
        if (this.root == null) return;
        Assert.assertNotNull(inOutList);
        _bfs(inOutList);
    }

    private void _bfs(ArrayList<Integer> inoutList) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            visited.add(node);
            inoutList.add(node.data);

            if (node.leftChild != null && !visited.contains(node.leftChild)) queue.add(node.leftChild);
            if (node.rightChild != null && !visited.contains(node.rightChild)) queue.add(node.rightChild);
        }
    }

    /**
     * DFS the Binary Search Tree
     *
     * @param inoutList
     */
    public void depthFirstSearch(ArrayList<Integer> inoutList) {
        if (this.root == null) return;
        Assert.assertNotNull(inoutList);
        _dfs(inoutList);
    }

    private void _dfs(ArrayList<Integer> inoutList) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(this.root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visited.add(node);
            inoutList.add(node.data);

            if (node.leftChild != null && !visited.contains(node.leftChild)) stack.add(node.leftChild);
            if (node.rightChild != null && !visited.contains(node.rightChild)) stack.add(node.rightChild);
        }
    }

    /**
     * Weight First Search (A Heuristic Search example)
     *
     * @param inoutList
     */
    public void weightFirstSearch(ArrayList<Integer> inoutList) {
        if (this.root == null) return;
        Assert.assertNotNull(inoutList);
        _wfs(inoutList);
    }

    private void _wfs(ArrayList<Integer> inoutList) {
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<TreeNode>();
//        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<TreeNode>((a,b) -> b.data - a.data);
        Set<TreeNode> visited = new HashSet<>();
        priorityQueue.offer(this.root);
        while (!priorityQueue.isEmpty()) {
            TreeNode node = priorityQueue.poll();
            visited.add(node);
            inoutList.add(node.data);
            if (node.leftChild != null && !visited.contains(node.leftChild)) priorityQueue.offer(node.leftChild);
            if (node.rightChild != null && !visited.contains(node.rightChild)) priorityQueue.offer(node.rightChild);
        }
    }
}
