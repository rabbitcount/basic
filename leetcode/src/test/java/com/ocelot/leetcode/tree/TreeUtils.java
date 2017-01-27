package com.ocelot.leetcode.tree;

import java.util.Random;

/**
 * Created by gaoxiang on 2017/1/22.
 */
public class TreeUtils {

    private static final Random RANDOM = new Random();

    /**
     * 随机构造包含count个节点的二叉树
     *
     * @param count 节点个数
     * @return 随机树的根节点
     */
    public static final TreeContext create(int count) {
        TreeContext context = new TreeContext();
        if (count < 1) {
            return context;
        }
        // 设置minDepth的初始值，用于后续比对
        context.setMinDepth(count);
        TreeNode root = createSubTree(count, 0, context);
        context.setTreeNode(root);
        return context;
    }

    /**
     * 生成新节点，并递归调用生成子节点
     * <p>
     * 注意：判断节点适合放在哪里
     *
     * @param num         待构成的子树中含有节点的数量
     * @param parentDepth 父节点的depth
     * @param context     上下文信息，保存统计数据
     * @return
     */
    private static final TreeNode createSubTree(int num, int parentDepth, TreeContext context) {
        int curDepth = parentDepth + 1;
        // 输入参数校验保护，针对0的情况
        if (num < 1) {
//            context.setMinDepth(Integer.min(context.getMinDepth(), parentDepth));
//            if (context.getMinDepth() > parentDepth) {
//                context.setMinDepth(parentDepth);
//            }
            return null;
        } else if(num < 2) {
            context.setMinDepth(Integer.min(context.getMinDepth(), curDepth));
        }

        TreeNode root = new TreeNode();
        // 去除根节点数量
        num -= 1;
        // 增加当前深度
        if (context.getHeight() < curDepth) {
            context.setHeight(curDepth);
        }

        if (num > 0) {
            int left = RANDOM.nextInt(num);
            root.setLeft(createSubTree(left, curDepth, context));
            int right = num - left;
            root.setRight(createSubTree(right, curDepth, context));
        }
        return root;
    }

    public static void main(String[] args) {
        TreeContext context = TreeUtils.create(10);
        System.out.println(1);
    }
}
