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
        for (int index = 1; index < 6; index++) {
            LinkedListNode<Integer> node = new LinkedListNode<>();
            node.setValue(index);
            cur.setNext(node);
            cur = cur.getNext();
        }
        LinkedListNode<Integer> ret = ReverseLinkedList.reverseLinkedListBetweenMN(dummy.getNext(), 2, 4);
        System.out.println("1");
    }
}
