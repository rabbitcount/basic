package com.ocelot.leetcode.linkedlist.duplicate;

import com.ocelot.leetcode.linkedlist.LinkedListNode;

import java.util.Objects;

/**
 * Question1 :
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *  For example,
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Description
 *  在一个有序的链表里面删除重复的元素，只保留一个，也是比较简单的一个题目，我们只需要判断当前指针以及下一个指针时候重复，如果是，则删除下一个指针就可以了。
 * <p>
 * Tip
 *  值相等，而非对象相等
 *
 * ----------------------------------------------------------------
 * Question2:
 *  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *  For example,
 *  Given 1->2->3->3->4->4->5, return 1->2->5.
 *  Given 1->1->1->2->3, return 2->3.
 * <p>
 * Description
 *  在一个有序的链表里面删除所有的重复元素的节点。因为不同于上题可以保留一个，这次需要全部删除，所以我们遍历的时候需要记录一个prev节点，用来处理删除节点之后节点重新连接的问题。
 * c
 * Tip
 *  值相等，而非对象相等
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 多个重复节点需要保留其中一个
     *
     * @param head
     * @return
     */
    public static LinkedListNode retainOne(LinkedListNode head) {
        if(Objects.isNull(head)) {
            return head;
        }
        // 初始值的value
        Object value = head.getValue();
        LinkedListNode node = head;
        while(Objects.nonNull(node) && Objects.nonNull(node.getNext())) {
            if(node.getNext().getValue().equals(value)) {
                // 发现重复值
                node.setNext(node.getNext().getNext());
            } else {
                // 值不重复
                value = node.getNext().getValue();
                node = node.getNext();
            }
        }
        return head;
    }

    /**
     * 删除所有重复的节点
     *
     * @param head
     * @return
     */
    public static LinkedListNode removeDuplicateNodes(LinkedListNode head) {
        if(Objects.isNull(head)) {
            return head;
        }
        // 首节点可能会被删除，是否需要建立虚拟节点，虚拟节点指向首节点
        LinkedListNode dummy = new LinkedListNode();
        dummy.setNext(head);
        LinkedListNode pre = dummy;
        LinkedListNode node = head;
        while(Objects.nonNull(node) && Objects.nonNull(node.getNext())) {
            if(node.getNext().getValue().equals(node.getValue())) {
                // 相等
                LinkedListNode duplicate = node.getNext().getNext();
                while(Objects.nonNull(duplicate)) {
                    if(!duplicate.getValue().equals(node.getValue())) {
                        break;
                    }
                    duplicate = duplicate.getNext();
                }
                pre.setNext(duplicate);
                node = duplicate;
            } else {
                // 不相等
                pre = node;
                node = node.getNext();
            }
        }
        return dummy.getNext();
    }
}
