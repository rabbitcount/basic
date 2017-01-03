package com.ocelot.leetcode.linkedlist.reverse;

import com.ocelot.leetcode.linkedlist.LinkedListNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/3.
 */
public class ReverseLinkedList {

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * <p>
     * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * <p>
     * return 1->4->3->2->5->NULL.
     * <p>
     * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
     * <p>
     * 这题要求我们翻转[m, n]区间之间的链表。对于链表翻转来说，几乎都是通用的做法，譬如p1 -> p2 -> p3 -> p4，如果我们要翻转p2和p3，其实就是将p3挂载到p1的后面，所以我们需要知道p2的前驱节点p1。伪代码如下：
     *
     * @param list
     * @param m
     * @param n
     * @param <T>
     */
    public static <T extends Comparable<T>> LinkedListNode<T> reverseLinkedListBetweenMN(LinkedListNode<T> list, int m, int n) {
        if (Objects.isNull(list)) {
            return null;
        }

        LinkedListNode<T> dummy = new LinkedListNode<T>();
        dummy.setNext(list);

        LinkedListNode<T> cur = dummy;

        for (int index = 1; index < m; index++) {
            cur = cur.getNext();
        }

        LinkedListNode<T> pm = cur.getNext();

        for (int index = m; index < n; index++) {
            LinkedListNode<T> temp = pm.getNext();
            pm.setNext(temp.getNext());
            temp.setNext(cur.getNext());
            cur.setNext(temp);
        }
        return dummy.getNext();
    }
}
