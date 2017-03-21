package me.lirui.algo.tree;

/**
 * Created by RichardLee on 2017/3/21.
 */
public class BinarySearchTree {
    // root node
    TreeNode root;

    // Do nothing
    public BinarySearchTree(){
    }


    //
    // Insert the node to the BST
    //
    // addTreeNode the value item into the BST
    public TreeNode addTreeNode(int value){
        //
        return addTreeNode(this.root, value);
    }

    /**
     *
     * 添加节点
     *
     * @param root
     * @param value
     * @return
     */
    private  TreeNode addTreeNode(TreeNode root, int value){
        if (root == null){
            this.root = new TreeNode();
            this.root.data = value;
            return this.root;
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

    public TreeNode searchNode(int value){
        return searchNode(this.root, value);
    }

    /**
     *
     * 查找节点
     *
     * @param root
     * @param value
     * @return
     */
    private TreeNode searchNode(TreeNode root, int value){
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

    public TreeNode deleteNode(int value){
        return deleteNode(this.root, value);
    }

    private  TreeNode deleteNode(TreeNode root, int value){
        if (root == null) {
            return null;
        }

        int rootValue = root.data;
        if (value < rootValue) {
            root.leftChild = deleteNode(root.leftChild, value);
        } else if (value > rootValue) {
            root.rightChild = deleteNode(root.rightChild, value);
        } else {
            if (root.leftChild != null && root.rightChild != null) {
                // search for the min node in right child subtree,
                // and then replace the current node.
                //
                TreeNode newRootNode = findMin(root.rightChild);
                // remove from the previous right subtree
                root.rightChild = deleteNode(newRootNode, newRootNode.data);
                // replace the current node.
                root.data = newRootNode.data;
            } else if (root.leftChild == null  && root.rightChild != null){
                root = root.rightChild;
            } else if (root.rightChild == null && root.leftChild != null){
                root = root.leftChild;
            } else {
                root = null;
            }
        }

       return root;
    }

    //
    private TreeNode findMin(TreeNode node){
        if (node == null){
            return  null;
        }
        TreeNode leftNode = node.leftChild;
        return leftNode == null ?
                leftNode: findMin(leftNode.leftChild);
    }

}
