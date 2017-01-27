package com.ocelot.leetcode.tree.pathsum;

import com.ocelot.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/27.
 */
public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals the given sum.
     * <p>
     * For example: Given the below binary tree and sum = 22,
     * <p>
     * 题目翻译
     * 给定一颗二叉树和一个特定值，写一个方法来判定这棵树是否存在这样一种条件，使得从root到其中一个叶子节点的路径的和等于给定的sum值.
     * <p>
     * 解题思路
     * 这道题很常规，直接用DFS就可以求解.
     * <p>
     * 时间复杂度
     * O(n)
     *
     * @param root
     * @param expectValue
     * @return
     */
    public static final boolean hasPathSum(TreeNode root, int expectValue) {
        return dfs(root, expectValue, 0);
    }

    private static final boolean dfs(TreeNode root, int expectValue, int sum) {
        if (Objects.isNull(root)) {
            return false;
        }
        sum += root.getValue();

        // 到达当前路径的叶子节点，判断返回是否符合条件
        if (Objects.isNull(root.getLeft()) && Objects.isNull(root.getRight())) {
            return sum == expectValue ? true : false;
        }
        // 如果左子树符合条件，可以实现优先返回，避免无用计算
        return dfs(root.getLeft(), expectValue, sum) || dfs(root.getRight(), expectValue, sum);
    }

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * 题目翻译
     * 给定一个二叉树，并且给定一个值，找出所有从根节点到叶子节点和等于这个给定值的路径.上面的例子可以很好地让读者理解这个题目的目的.
     *
     * 与题目1的区别
     * 1. 找到所有的路径
     * 2. 并返回路径信息
     *
     * 解题思路
     * 这个题目和Path Sum的解法几乎是一模一样，都是用dfs来进行求解，不过就是在传参数的时候有些不同了，因为题目的要求也不同.
     *
     * 时间复杂度: O(n)
     *
     * 来源
     * https://discuss.leetcode.com/topic/5414/dfs-with-one-linkedlist-accepted-java-solution/8
     * with back-tracking(尾递归)
     *
     * @param root
     * @param expectValue
     */
    public static final List<List<Integer>> foundMatchPathSum(TreeNode root, int expectValue) {
        List<List<Integer>>ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        pathSum(root, expectValue, cur, ret);
        return ret;
    }

    /**
     * NOTE
     * cur 的移出位置很精致
     * @param root
     * @param sum
     * @param cur
     * @param ret
     */
    public static final void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
        if (root == null){
            return;
        }
        // 将当前节点加入到数据链路中
        cur.add(root.getValue());
        if (root.getLeft() == null && root.getRight() == null && root.getValue() == sum){
            // 到达匹配的叶子节点
            ret.add(new ArrayList(cur));
        }else{
            pathSum(root.getLeft(), sum - root.getValue(), cur, ret);
            pathSum(root.getRight(), sum - root.getValue(), cur, ret);
        }
        // 回归的时候，将当前节点移除
        cur.remove(cur.size()-1);
    }

}











































