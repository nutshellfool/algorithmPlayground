package me.lirui.algo.tree;

/**
 * Created by RichardLee on 2017/3/21.
 */
public class TreeNode {

    // left child node
    TreeNode leftChild;

    // left rightChild
    TreeNode rightChild;

    int     data;

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }


    public  TreeNode (){
        super();
    }

    public TreeNode (int value){
        super();
        this.data = value;
    }

}
