package com.ocelot.leetcode.linkedlist.cycle;

import com.ocelot.leetcode.linkedlist.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaoxiang on 2016/12/25.
 * 链表为null          false
 * 链表只有一个元素     true
 * 链表有两个元素（有环）true
 * 链表有两个元素（无环）false
 * 链表有三个元素（有环）true
 * 链表有三个元素（无环）false
 */
public class LinkedListCycleTest {

    /**
     * 测试链表为空
     */
    @Test
    public void testNullLinkedList() {
        boolean f = LinkedListCycle.hasCycle(null);
        assertFalse(f);
    }

    @Test
    public void testSingleLinkedList() {
        LinkedListNode first = new LinkedListNode();
        boolean f = LinkedListCycle.hasCycle(first);
        assertFalse(f);
    }

    @Test
    public void testSingleCycleLinkedList() {
        LinkedListNode first = new LinkedListNode();
        first.setNext(first);
        boolean f = LinkedListCycle.hasCycle(first);
        assertTrue(f);
    }

    @Test
    public void testCycleTwiceLinkedList() {
        LinkedListNode first = new LinkedListNode();
        LinkedListNode second = new LinkedListNode();
        first.setNext(second);
        second.setNext(first);
        boolean f = LinkedListCycle.hasCycle(first);
        assertTrue(f);
    }

    @Test
    public void testCycleLinkedList() {
        LinkedListNode first = new LinkedListNode();
        LinkedListNode second = new LinkedListNode();
        LinkedListNode third = new LinkedListNode();
        LinkedListNode forth = new LinkedListNode();
        first.setNext(second);
        second.setNext(third);
        third.setNext(forth);
        forth.setNext(second);
        boolean f = LinkedListCycle.hasCycle(first);
        assertTrue(f);
    }

    @Test
    public void testLinkedList() {
        LinkedListNode first = new LinkedListNode();
        LinkedListNode second = new LinkedListNode();
        LinkedListNode third = new LinkedListNode();
        LinkedListNode forth = new LinkedListNode();
        first.setNext(second);
        second.setNext(third);
        third.setNext(forth);
        boolean f = LinkedListCycle.hasCycle(first);
        assertFalse(f);
    }
}
