package com.ocelot.leetcode.tree.balanced;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/27.
 */
public class HeightBalanced {

    /**
     * Given a binary tree, determine if it is height-balanced.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * 题目翻译
     * 给定一颗二叉树， 写一个函数来检测这棵树是否是平衡二叉树. 对于这个问题, 一颗平衡树的定义是其中任意节点的左右子树的高度差不大于1.
     *
     * 解题思路
     * 这道题其实就是应用DFS，对于一颗二叉树边计算树的高度边计算差值，针对树里面的每一个节点计算它的左右子树的高度差，如果差值大于1，那么就返回-1，如果不大于1，从下往上再次检测.
     *
     * 时间复杂度: 由于是运用DFS，所以时间复杂度为O(n).
     * @param root
     * @return
     */
    public static final boolean isHeightBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        int height = getHeightOfSubTree(root);
        // 如果height为异常关键字，则子树非平衡
        if(ERROR_HEIGHT == height) {
            return false;
        } else {
            return true;
        }
    }
    private static final int ERROR_HEIGHT = -1;

    private static final int getHeightOfSubTree(TreeNode root) {
        if(Objects.isNull(root)) {
            return 0;
        }
        int leftHeight = getHeightOfSubTree(root.getLeft());
        if(ERROR_HEIGHT == leftHeight) {
            return ERROR_HEIGHT;
        }
        int rightHeight = getHeightOfSubTree(root.getRight());
        if(ERROR_HEIGHT == rightHeight) {
            return ERROR_HEIGHT;
        }
        // 高度差值为 -1 0 1为合理，其余返回ERROR_HEIGHT
        int diffHeight = leftHeight - rightHeight;
        if(diffHeight > 1 || diffHeight < -1) {
            return ERROR_HEIGHT;
        } else {
            // 返回子树的高度
            int maxOfSubTree = leftHeight > rightHeight? leftHeight: rightHeight;
            return maxOfSubTree + 1;
        }
    }
}
