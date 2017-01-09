package com.ocelot.leetcode.linkedlist.swap;

import com.ocelot.leetcode.linkedlist.LinkedListNode;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/9.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    public static <T extends Comparable<T>> LinkedListNode<T> swapPairs(LinkedListNode<T> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }

        LinkedListNode<T> dummy = new LinkedListNode<>();
        dummy.setNext(head);
        LinkedListNode<T> pre = dummy;

        while (Objects.nonNull(pre) && Objects.nonNull(pre.getNext()) && Objects.nonNull(pre.getNext().getNext())) {
            LinkedListNode<T> cur = pre.getNext();
            LinkedListNode<T> next = cur.getNext();
            pre.setNext(next);
            cur.setNext(next.getNext());
            next.setNext(cur);

            pre = pre.getNext().getNext();
        }
        return dummy.getNext();
    }
}
