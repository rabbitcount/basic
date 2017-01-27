package com.ocelot.leetcode.tree.same;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/27.
 */
public class SameTree {

    /**
     * Given two binary trees, write a function to check if they are equal or not. Two binary trees are considered equal
     * if they are structurally identical and the nodes have the same values.
     *
     * 题目翻译:
     * 给两棵树，写一个函数来判断这两棵树是否相同. 我们判定一棵树是否相同的条件为这两棵树的结构相同，并且每个节点的值相同.
     *
     * 解题思路:
     * 这道题中规中矩，很简单，我们直接用DFS前序遍历这两棵树就可以了.
     * 基于递归的前序遍历
     *
     * 时间复杂度分析: 因为是DFS, 所以时间复杂度为O(n)
     *
     * @param first
     * @param second
     * @return
     */
    public static final boolean isSameTree(TreeNode first, TreeNode second) {
        if(Objects.isNull(first) && Objects.isNull(second)) {
            return true;
        } else if(Objects.isNull(first) || Objects.isNull(second)) {
            // 任一为空
            return false;
        }
        // 均不为空
        if(first.getValue().equals(second.getValue())) {
            boolean leftSame = isSameTree(first.getLeft(), second.getLeft());
            boolean rightSame = isSameTree(first.getRight(), second.getRight());
            return leftSame && rightSame;
        }
        return true;
    }
}
