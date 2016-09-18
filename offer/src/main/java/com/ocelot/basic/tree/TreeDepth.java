package com.ocelot.basic.tree;

import com.ocelot.basic.base.BST;
import com.ocelot.basic.base.BSTUtils;
import com.ocelot.basic.tree.entity.BalanceContect;

import java.util.List;
import java.util.Objects;


public class TreeDepth {

    /**
     * Q: 输入一棵二叉树的根节点。求该树的深度?
     *   从根节点到叶节点一次经过的节点(含根、叶节点)
     *   形成树的一条路径,最长路径的长度为树的深度
     * A: 树的深度等于树的高度。节点的高度等于其左右子树高度较大值 + 1
     */
    public static int getTreeDepth(BST.Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int leftDepth = getTreeDepth(node.getLeft());
        int rigthDepth = getTreeDepth(node.getRight());
        return leftDepth > rigthDepth ? leftDepth + 1 : rigthDepth + 1;
    }

    /**
     * Q: 输入一棵二叉树的根节点,判断该树是不是平衡二叉树。
     *    如果某二叉树中任意节点的左子树的深度不超过1,那么它就是一棵平衡二叉树
     */
    public static boolean isBalanced(BST.Node node) {
        BalanceContect ret = isBanlanceda(node);
        return ret.isBalanced();
    }

    private static BalanceContect isBanlanceda(BST.Node node) {
        if(Objects.isNull(node)) {
            return new BalanceContect(true);
        }
        BalanceContect leftContext = isBanlanceda(node.getLeft());
        if(!leftContext.isBalanced()) {
            return new BalanceContect(false);
        }
        BalanceContect rightContext = isBanlanceda(node.getRight());
        if(!rightContext.isBalanced()) {
            return new BalanceContect(false);
        }

        int leftHeigth = leftContext.getLeftHeight() > leftContext.getRightHeight()?leftContext.getLeftHeight(): leftContext.getRightHeight();
        int rightHeight = rightContext.getLeftHeight() > rightContext.getRightHeight()?rightContext.getLeftHeight(): rightContext.getRightHeight();
        int diff = leftHeigth - rightHeight;
        if(diff >= - 1 && diff <= 1) {
            BalanceContect ret = new BalanceContect(true);
            ret.setLeftHeight(leftHeigth + 1);
            ret.setRightHeight(rightHeight + 1);
            return ret;
        }
        return new BalanceContect(false);
    }

    public static void main(String[] args) {
        List<String> keys = BSTUtils.createBSTInp(4);
        BST bst = BSTUtils.createBST(keys);
//        int count = TreeDepth.getTreeDepth(bst.getRoot());
//        System.out.println(count);
        System.out.println(TreeDepth.isBalanced(bst.getRoot()));
    }

}
