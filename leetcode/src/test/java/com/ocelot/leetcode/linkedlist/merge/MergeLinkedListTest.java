package com.ocelot.leetcode.linkedlist.merge;

import com.ocelot.leetcode.linkedlist.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaoxiang on 2016/12/31.
 */
public class MergeLinkedListTest {

    private static final int RANDOM_LIMIT = 100;

    @Test
    public void testMergeTwoAllNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(null, null);
        assertTrue(Objects.isNull(result));
    }

    @Test
    public void testMergeTwoFirstListIsNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(null, createSortedList(1));
        assertEquals(1, getLength(result));
        assertTrue(isSorted(result));
    }

    @Test
    public void testMergeTwoSecondListIsNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(createSortedList(1), null);
        assertEquals(1, getLength(result));
        assertTrue(isSorted(result));
    }

    @Test
    public void testMergeTwoMergeWithRandomList() {
        int M = randomGenerateIntValue();
        int N = randomGenerateIntValue();
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(createSortedList(M), createSortedList(N));
        assertEquals(M + N, getLength(result));
        assertTrue(isSorted(result));
    }

    @Test
    public void testMergeKListsWithRandomLists() {
        int n = randomGenerateIntValue();
        LinkedListNode<Integer>[] lists = new LinkedListNode[n];
        int sum = 0;
        for (int index = 0; index < n; index++) {
            int positionLength = randomGenerateIntValue();
            sum += positionLength;
            lists[index] = createSortedList(positionLength);
        }
        LinkedListNode<Integer> result = MergeLinkedList.mergeKLists(lists);
        assertEquals(sum, getLength(result));
        assertTrue(isSorted(result));
    }

    /**
     * 随机创建N个节点的链表
     *
     * @param N
     * @return
     */
    private LinkedListNode<Integer> createSortedList(int N) {
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
    private boolean isSorted(LinkedListNode<Integer> l) {
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
    private int getLength(LinkedListNode<Integer> l) {
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
    private int randomGenerateIntValue() {
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
    private int[] createSortedValues(int N) {
        Random random = new Random(System.currentTimeMillis());
        int[] values = new int[N];
        for (int index = 0; index < N; index++) {
            values[index] = random.nextInt();
        }
        Arrays.sort(values);
        return values;
    }
}
