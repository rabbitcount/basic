package com.ocelot.leetcode.tree.depth;

import com.ocelot.leetcode.tree.TreeContext;
import com.ocelot.leetcode.tree.TreeUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaoxiang on 2017/1/22.
 */
public class DepthOfBinaryTreeTest {

    @Test
    public void maxDepthTestWithNull() {
        assertEquals(0, DepthOfBinaryTree.maxDepth(null));
    }

    @Test
    public void maxDepthTest() {
        for (int index = 0; index < 100; index++) {
            TreeContext context = TreeUtils.create(index);
            int maxDepth = DepthOfBinaryTree.maxDepth(context.getTreeNode());
            assertEquals(context.getHeight(), maxDepth);
        }
    }

    @Test
    public void minDepthTest() {
        for(int index = 0; index < 1000; index++) {
            TreeContext context = TreeUtils.create(index);
            int minDepth = DepthOfBinaryTree.minDepth(context.getTreeNode());
            assertEquals(context.getMinDepth(), minDepth);
        }
    }
}
