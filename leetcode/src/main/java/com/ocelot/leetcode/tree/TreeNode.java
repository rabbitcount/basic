package com.ocelot.leetcode.tree;

/**
 * Created by gaoxiang on 2017/1/22.
 */
public class TreeNode {

    private Integer value = null;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode() {

    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
