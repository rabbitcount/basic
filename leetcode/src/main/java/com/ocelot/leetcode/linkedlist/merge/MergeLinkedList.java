package com.ocelot.leetcode.linkedlist.merge;

import com.ocelot.leetcode.linkedlist.LinkedListNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2016/12/31.
 */
public class MergeLinkedList {

    /**
     * Question:
     * Merge Two Sorted Lists
     * [Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.]
     * <p>
     * Tips:
     * merge两个已经排序的链表，生成新的列表并返回（新链表不一定完整使用老链表中的对象）
     *
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> LinkedListNode<T> mergeTwoLists(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        LinkedListNode result = new LinkedListNode();
        LinkedListNode cur = result;

        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            T val1 = l1.getValue();
            T val2 = l2.getValue();

            if (val1.compareTo(val2) < 0) {
                cur.setNext(l1);
                cur = l1;
                l1 = l1.getNext();
            } else {
                cur.setNext(l2);
                cur = l2;
                l2 = l2.getNext();
            }
        }

        if (Objects.isNull(l1)) {
            cur.setNext(l2);
        } else if (Objects.isNull(l2)) {
            cur.setNext(l1);
        }
        // result指向预定义的虚拟首节点，getNext得到预期返回的真实节点
        return result.getNext();
    }

    /**
     * Question
     * Merge k Sorted Lists
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Tips
     * Divide and Conquor
     * 这题需要合并k个排好序的链表，我们采用divide and conquer的方法，首先两两合并，然后再将先前合并的继续两两合并。时间复杂度为O(NlgN)。
     *
     * Dependency
     * 基于 mergeTwoLists
     * @param lists
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> LinkedListNode<T> mergeKLists(LinkedListNode<T>[] lists) {
        if (Objects.isNull(lists) || lists.length == 0) {
            return null;
        }

        int n = lists.length;
        while (n > 1) {
            // 为什么加1
            int k = (n + 1) / 2;
            for (int index = 0; index < n / 2; index++) {
                lists[index] = mergeTwoLists(lists[index], lists[index + k]);
            }
            n = k;
        }
        return lists[0];
    }

}
