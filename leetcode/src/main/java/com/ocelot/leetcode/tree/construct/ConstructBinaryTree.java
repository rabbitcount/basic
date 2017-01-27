package com.ocelot.leetcode.tree.construct;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/26.
 */
public class ConstructBinaryTree {

    public static final TreeNode buildBinaryTreeWithInorderAndPostOrderTraversal(Integer[] inorder, Integer[] postOrder) {
        if (Objects.isNull(inorder) || Objects.isNull(postOrder)) {
            return null;
        } else if (inorder.length != postOrder.length) {
            return null;
        }
        return buildBinaryTree(inorder, 0, inorder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    private static final TreeNode buildBinaryTree(Integer[] inorder, int inStart, int inEnd, Integer[] postOrder, int postStart, int postEnd) {
        // 结束条件
        if(inEnd < inStart || postEnd < postStart) {
            return null;
        }
        // 后续最后一个节点为根节点
        Integer rootValue = postOrder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int index = inStart;
        for (; index <= inEnd; index++) {
            if (inorder[index].equals(rootValue)) {
                break;
            }
        }
        root.setLeft(buildBinaryTree(inorder, inStart, index - 1, postOrder, postStart, postStart + index - 1 - inStart));
        root.setRight(buildBinaryTree(inorder, index + 1, inEnd, postOrder, postStart + index - inStart, postEnd - 1));
        return root;
    }
}
