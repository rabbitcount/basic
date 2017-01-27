package com.ocelot.leetcode.tree;

/**
 * Created by gaoxiang on 2017/1/25.
 */
public class TreeContext {

    // 树的高度（根节点到最远的叶子节点，节点数量，含首尾）
    private int height = 0;

    // 根节点到最近的叶节点
    private int minDepth = 0;

    private TreeNode treeNode = null;

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMinDepth() {
        return minDepth;
    }

    public void setMinDepth(int minDepth) {
        this.minDepth = minDepth;
    }
}