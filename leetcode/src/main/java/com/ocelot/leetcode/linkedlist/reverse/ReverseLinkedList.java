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

        LinkedListNode<T> pre = dummy;

        for (int index = 1; index < m; index++) {
            pre = pre.getNext();
        }

        LinkedListNode<T> cur = pre.getNext();

        // [step1] get next node
        //
        //   1(pre) -> 3 -> 2(cur) -> 4(next) -> 5
        //
        // [step2] assign next'next to cur's next
        //
        //   1(pre)  -> 3 -> 2(cur) -> 5
        //   4(next) -> 5
        //
        // [step3] insert 4(next) between 1(pre) and 3(pre.next)
        //
        //   1(pre)  ->  3 -> 2(cur) -> 5
        //   4(next) ->
        //
        //
        //
        // pre和next指向的节点没有变动过
        for (int index = m; index < n; index++) {
            // step1
            LinkedListNode<T> next = cur.getNext();
            // step2
            cur.setNext(next.getNext());
            // step3
            next.setNext(pre.getNext());
            pre.setNext(next);
        }
        return dummy.getNext();
    }

    /**
     * Question
     *   Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     *   If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *   You may not alter the values in the nodes, only nodes itself may be changed.
     *   Only constant memory is allowed.
     *   For example, Given this linked list: 1->2->3->4->5
     *   For k = 2, you should return: 2->1->4->3->5
     *   For k = 3, you should return: 3->2->1->4->5
     *
     * Tip
     *   1. 需要明白翻转到底意味什么？
     *   2. 每次都需要知道当前待反转k group的前驱节点。
     *
     * Solution
     *   1. 创建链表的dummy head，人造一个前驱节点
     *   2. 每次找到需要反转的k个元素
     *   3. 针对k各元素进行反转
     * @param head
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> LinkedListNode<T> reverseKGroup(LinkedListNode<T> head, int k) {
        if(k <= 1 || Objects.isNull(head)) {
            return head;
        }

        LinkedListNode<T> dummy = new LinkedListNode<>();
        dummy.setNext(head);

        LinkedListNode<T> cur = dummy;
        LinkedListNode<T> prev = null;

        while(Objects.nonNull(cur)) {
            prev = cur;

            for(int index = 0; index < k; index++) {
                cur = cur.getNext();
                if(Objects.isNull(cur)) {
                    // 无法构成k个分组，直接返回结果
                    return dummy.getNext();
                }
            }
            cur = reverse(prev, cur);
        }
        return dummy.getNext();
    }

    /**
     * reverse范围：(pre, end]
     *
     * dummy[prev] -> node-k1[first] -> node-k2 -> node-k3[end] -> node(分组外)
     * 假设 k = 3
     *
     * 1. k = 3, 已经进行一次翻转后，预期将k3放到k2,k1之前，prev之后
     *   dummy[prev] -> node-k2 -> node-k1[first] -> node-k3[end] -> node(分组外)
     * 2. 将k3后的节点连接到k1之后
     *   dummy[prev] -> node-k2 -> <b>node-k1[first] -> node(分组外)</b>
     *   <b>node-k3(end)</b> -> node(分组外)
     * 3. 将k3插入(k1,k2之前，prev之后 -- prev和k2之间)
     *   dummy[prev] -> <b>node-k3[end]</b> -> node-k2 -> node-k1[first] -> node(分组外)
     *
     * 终止条件：全部翻转完成，prev的next是end节点
     *   {{ <b> dummy[prev] -> node-k3[end] </b> }} -> node-k2 -> node-k1[first] -> node(分组外)
     * @param prev 待翻转的k group的前置节点
     * @param end 待翻转的k group的最后节点
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> LinkedListNode<T> reverse(LinkedListNode<T> prev, LinkedListNode<T> end) {
        // cur 将被插入到前驱组合前驱组的前驱之间
        LinkedListNode<T> first = prev.getNext();
        if(Objects.isNull(first)) {
            return first;
        }

        // 终止条件：全部翻转完成，prev的next是end节点
        // {{ dummy[prev] -> node-k3[end] }} -> node-k2 -> node-k1[first] -> node(分组外)
        while(prev.getNext() != end) {
            //
            LinkedListNode<T> cur = first.getNext();
            first.setNext(cur.getNext());
            //
            cur.setNext(prev.getNext());
            prev.setNext(cur);
        }
        return first;
    }
}
