package com.play;

/**
 * This class is meant to provide the model for TreeNode to represent a binary tree
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[ Node value : " + this.val + " , { Left : " + this.right + " , Right : " + this.right + " } ]";
    }
}