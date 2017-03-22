package me.lirui.algo.tree;

/**
 * Created by RichardLee on 2017/3/21.
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
     * 添加节点
     *
     * @param value
     * @return
     */
    public TreeNode addTreeNode(int value) {
        //
        if (this.root == null) {
            this.root = new TreeNode(value);
        }

        return addTreeNode(this.root, value);
    }

    private  TreeNode addTreeNode(TreeNode root, int value) {
        if (root == null){
            return new TreeNode(value);
        }

        int valueOfrootElement = root.data;
        if (value < valueOfrootElement){
            root.leftChild = addTreeNode(root.leftChild, value);
        }else if (value > valueOfrootElement){
            root.rightChild = addTreeNode(root.rightChild, value);
        }else {
            root.data = value;
        }

        return root;
    }

    /**
     *
     * 查找节点
     *
     * @param root
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
     * 删除节点
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

}
