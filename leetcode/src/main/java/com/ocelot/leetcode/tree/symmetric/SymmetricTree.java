package com.ocelot.leetcode.tree.symmetric;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by gaoxiang on 2017/1/27.
 */
public class SymmetricTree {

    /**
     * 递归方式判断一棵二叉树是否为自镜像
     * 基于DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param root
     * @return
     */
    public static final boolean isSymmetricWithRecursion(TreeNode root) {
        if(Objects.isNull(root)) {
            return true;
        }
        return isSymmetricHelper(root.getLeft(), root.getRight());
    }

    /**
     * 自镜像需要满足三个条件
     * 1. 左右子树的根节点相等
     * 2. 左节点的左子树和右节点的右子树是镜像
     * 3. 左节点的右子树和右节点的左子树是镜像
     * 满足以上条件，则认为两颗树互为镜像
     *
     * @param left
     * @param right
     * @return
     */
    private static final boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }
        boolean cmpRoot = left.getValue().equals(right.getValue());
        boolean cmpSub1 = isSymmetricHelper(left.getLeft(), right.getRight());
        boolean cpmSub2 = isSymmetricHelper(left.getRight(), left.getLeft());
        return cmpRoot && cmpSub1 && cpmSub2;
    }

    /**
     * 遍历方法验证当前树是否为自镜像
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 使用LinkedList
     * @param root
     * @return
     */
    public static final boolean isSymmetricWithLoop(TreeNode root) {
        if(Objects.isNull(root)) {
            return true;
        }
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if(Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        } else if(Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }
        LinkedList<TreeNode> leftQueue = new LinkedList<>();
        LinkedList<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(left);
        rightQueue.add(right);
        // 队列不为空
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            // NOTE
            // 使用LinkedList可以实现FIFO的队列需求
            // 基于LinkedList的两个特性
            // 1. LinkedList可以插入null
            // 2. LinkedList的addLast和removeFirst的时间成本都是常量；
            TreeNode tempLeft = leftQueue.removeFirst();
            TreeNode tempRight = rightQueue.removeFirst();
            // 一个为空，一个不为空时，返回false，不匹配
            if(Objects.isNull(tempLeft) || Objects.isNull(tempRight)) {
                return false;
            }
            // 两个都不为空
            // 值不相等，返回false
            if(!tempLeft.getValue().equals(tempRight.getValue())) {
                return false;
            }
            // 左右Q的加入顺序要相反，一个先left，一个先right
            leftQueue.add(tempLeft.getLeft());
            leftQueue.add(tempLeft.getRight());

            rightQueue.add(tempRight.getRight());
            rightQueue.add(tempRight.getLeft());
        }
        return true;
    }

}
