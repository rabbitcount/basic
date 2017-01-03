package com.ocelot.leetcode.linkedlist.duplicate;

import com.ocelot.leetcode.linkedlist.LinkedListNode;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * Created by gaoxiang on 2016/12/25.
 */
public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void nullList() {
        LinkedListNode result = RemoveDuplicatesFromSortedList.retainOne(null);
        assertNull(result);
    }

    @Test
    public void notDuplicate() {
        LinkedListNode first1 = create("first1");
        LinkedListNode first2 = create("first2");
        first1.setNext(first2);
        LinkedListNode first3 = create("first3");
        first2.setNext(first3);
        LinkedListNode result = RemoveDuplicatesFromSortedList.retainOne(first1);
        assertSame(3, getLinkedListLength(result));
    }

    @Test
    public void duplicateAll() {
        LinkedListNode first1 = create("first");
        LinkedListNode first2 = create("first");
        first1.setNext(first2);
        LinkedListNode first3 = create("first");
        first2.setNext(first3);
        LinkedListNode result = RemoveDuplicatesFromSortedList.retainOne(first1);
        assertSame(1, getLinkedListLength(result));
    }

    @Test
    public void duplicate() {
        LinkedListNode first1 = create("first1");
        LinkedListNode first2 = create("first");
        first1.setNext(first2);
        LinkedListNode first3 = create("first");
        first2.setNext(first3);
        LinkedListNode result = RemoveDuplicatesFromSortedList.retainOne(first1);
        assertSame(2, getLinkedListLength(result));
    }

    /**
     * 第一个不重复
     */
    @Test
    public void removeDuplicateNodesFirstNotDuplicate() {
        LinkedListNode first1 = create("first");
        LinkedListNode first2 = create("second", first1);
        LinkedListNode first3 = create("second", first2);
        LinkedListNode first4 = create("third", first3);
        LinkedListNode first5 = create("third", first4);
        create("third", first5);
        LinkedListNode result = RemoveDuplicatesFromSortedList.removeDuplicateNodes(first1);
        assertSame(1, getLinkedListLength(result));
    }

    /**
     * 第一个重复
     */
    @Test
    public void removeDuplicateNodesFirstDuplicate() {
        LinkedListNode first1 = create("first");
        LinkedListNode first2 = create("first", first1);
        LinkedListNode first3 = create("second", first2);
        LinkedListNode first4 = create("third", first3);
        LinkedListNode first5 = create("third", first4);
        create("third", first5);
        LinkedListNode result = RemoveDuplicatesFromSortedList.removeDuplicateNodes(first1);
        assertSame(1, getLinkedListLength(result));
    }

    /**
     * 创建链表节点
     * @param message
     * @return
     */
    private LinkedListNode create(String message) {
        LinkedListNode node = new LinkedListNode();
        node.setValue(message);
        return node;
    }

    /**
     * 创建新节点并添加到next
     * @param message
     * @param preNode
     * @return
     */
    private LinkedListNode create(String message, LinkedListNode preNode) {
        LinkedListNode node = new LinkedListNode();
        node.setValue(message);
        preNode.setNext(node);
        return node;
    }

    /**
     * 获取链表长度
     * @param head
     * @return
     */
    private int getLinkedListLength(LinkedListNode head) {
        int sum = 0;
        while(Objects.nonNull(head)) {
            sum++;
            head = head.getNext();
        }
        return sum;
    }
}
