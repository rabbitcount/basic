package com.ocelot.leetcode.tree.depth;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/22.
 */
public class DepthOfBinaryTree {

    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from
     * the root node down to the farthest leaf node.
     *
     * 这题要求我们求出一个二叉树最大深度，也就是从根节点到最远的叶子节点的距离。
     * 对于这题，我们只需要递归遍历二叉树，达到一个叶子节点的时候，记录深度，我们就能得到最深的深度了。
     *
     * 获取树的高度
     *
     * @param tn
     * @return
     */
    public static final int maxDepth(TreeNode tn) {

        if (Objects.isNull(tn)) {
            return 0;
        }

        return maxDepth(tn, 1, 1);
    }

    /**
     * @param tn        not null
     * @param curHeight 当前高度
     * @return max(height(left), height(right), curHeight)
     */
    private static final int maxDepth(TreeNode tn, int curHeight, int maxHeight) {
        if (Objects.isNull(tn.getLeft()) && Objects.isNull(tn.getRight())) {
            return max(curHeight, maxHeight);
        }

        if(Objects.nonNull(tn.getLeft())) {
            maxHeight = maxDepth(tn.getLeft(), curHeight + 1, maxHeight);
        }

        if(Objects.nonNull(tn.getRight())) {
            maxHeight = maxDepth(tn.getRight(), curHeight + 1, maxHeight);
        }
        return maxHeight;
    }

    private static final int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     *
     * 这题跟上题几乎一样，区别在于需要求出根节点到最近的叶子节点的深度，我们仍然使用遍历的方式。
     *
     * @param tn
     * @return
     */
    public static final int minDepth(TreeNode tn) {
        if(Objects.isNull(tn)) {
            return 0;
        }
        return minDepth(tn, 0, Integer.MAX_VALUE);
    }

    // tn一定不为空
    private static final int minDepth(TreeNode tn, int parentDepth, int minDepth) {

        int curDepth = parentDepth + 1;
        // 当前节点是叶子节点
        if(Objects.isNull(tn.getLeft()) && Objects.isNull(tn.getRight())) {
            return curDepth < minDepth? curDepth: minDepth;
        }
        if(Objects.nonNull(tn.getLeft())) {
            int leftMinDepth = minDepth(tn.getLeft(), parentDepth + 1, minDepth);
            minDepth = Integer.min(leftMinDepth, minDepth);
        }
        if(Objects.nonNull(tn.getRight())) {
            int rightMinDepth = minDepth(tn.getRight(), parentDepth + 1, minDepth);
            minDepth = Integer.min(rightMinDepth, minDepth);
        }
        return minDepth;
    }

}
