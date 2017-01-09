package com.ocelot.leetcode.linkedlist;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by gaoxiang on 2017/1/7.
 */
public class LinkedListUtils {

    private static final int RANDOM_LIMIT = 100;

    /**
     * 随机创建N个节点的链表
     *
     * @param N
     * @return
     */
    public static LinkedListNode<Integer> createSortedList(int N) {
        //
        int[] values = createSortedValues(N);

        LinkedListNode<Integer> dummy = new LinkedListNode<>();
        LinkedListNode<Integer> cur = dummy;
        for (int index = 0; index < N; index++) {
            LinkedListNode<Integer> node = new LinkedListNode<>();
            node.setValue(values[index]);
            cur.setNext(node);
            cur = cur.getNext();
        }
        return dummy.getNext();
    }

    /**
     * 验证链表是否已经排序
     * 如果为空，则认为已排序
     *
     * @param l
     * @return
     */
    public static boolean isSorted(LinkedListNode<Integer> l) {
        if (Objects.isNull(l)) {
            return true;
        }
        Integer curVal = Integer.MIN_VALUE;
        while (Objects.nonNull(l)) {
            if (curVal.compareTo(l.getValue()) > 0) {
                return false;
            }
            curVal = l.getValue();
            l = l.getNext();
        }
        return true;
    }

    /**
     * 获取链表长度
     *
     * @param l
     * @return
     */
    public static int getLength(LinkedListNode<Integer> l) {
        if (Objects.isNull(l)) {
            return 0;
        }
        int length = 0;
        while (Objects.nonNull(l)) {
            ++length;
            l = l.getNext();
        }
        return length;
    }

    /**
     * 随机生成正整数
     *
     * @return
     */
    public static int randomGenerateIntValue() {
        Random random = new Random(System.currentTimeMillis());
        int M = random.nextInt(RANDOM_LIMIT);
        if (M <= 0) {
            return -M + 1;
        }
        return M;
    }

    /**
     * 生成长度为N的数组，已排序
     *
     * @param N
     * @return
     */
    public static int[] createSortedValues(int N) {
        Random random = new Random(System.currentTimeMillis());
        int[] values = new int[N];
        for (int index = 0; index < N; index++) {
            values[index] = random.nextInt();
        }
        Arrays.sort(values);
        return values;
    }
}
