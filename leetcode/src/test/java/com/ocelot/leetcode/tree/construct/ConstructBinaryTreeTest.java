package com.ocelot.leetcode.tree.construct;

import com.ocelot.leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/26.
 */
public class ConstructBinaryTreeTest {

    @Test
    public void buildBinaryTreeWithInorderAndPostOrderTraversalTest() {
        Integer[] inorder = {4, 2, 5, 1, 6, 3, 7};
        Integer[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        Integer[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        TreeNode root = ConstructBinaryTree.buildBinaryTreeWithInorderAndPostOrderTraversal(inorder, postOrder);
        Context context = new Context(preOrder);
        preTraversal(root, context);
    }

    /**
     * 执行前序遍历
     * @param root
     * @param preOrder
     */
    private void preTraversal(TreeNode root, Context context) {
        if(Objects.isNull(root)) {
            return;
        }
        Integer value = root.getValue();
        if(!value.equals(context.getNext())) {
            throw new RuntimeException("不匹配");
        }
        preTraversal(root.getLeft(), context);
        preTraversal(root.getRight(), context);
    }

    private class Context {
        private Integer[] order;
        private int index = -1;

        public Context(Integer[] order) {
            this.order = order;
        }

        public Integer getNext() {
            return order[++index];
        }
    }
}
