package com.ocelot.leetcode.linkedlist.reverse;

import com.ocelot.leetcode.linkedlist.LinkedListNode;
import com.ocelot.leetcode.linkedlist.LinkedListUtils;
import org.junit.Test;

/**
 * Created by gaoxiang on 2017/1/7.
 */
public class ReverseLinkedListTest {

    @Test
    public void reverseLinkedListBetweenMNTest() {
        LinkedListNode<Integer> dummy = new LinkedListNode<>();
        LinkedListNode<Integer> cur = dummy;
        createSimpleLinkedList(cur, 6);
        LinkedListNode<Integer> ret = ReverseLinkedList.reverseLinkedListBetweenMN(dummy.getNext(), 2, 4);
        System.out.println("1");
    }

    @Test
    public void reverseKGroupTest() {
        LinkedListNode<Integer> dummy = new LinkedListNode<>();
        LinkedListNode<Integer> cur = dummy;
        createSimpleLinkedList(cur, 5);
        LinkedListNode<Integer> ret = ReverseLinkedList.reverseKGroup(dummy.getNext(), 2);
        System.out.println("1");
    }

    private static void createSimpleLinkedList(LinkedListNode<Integer> cur, int length) {
        for (int index = 1; index <= length; index++) {
            LinkedListNode<Integer> node = new LinkedListNode<>();
            node.setValue(index);
            cur.setNext(node);
            cur = cur.getNext();
        }
    }
}
