package com.ocelot.basic.linklist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class ReverseListTest {

    @Test
    public void reverseNullList() {
        ReverseList.ListNode<Integer> ret = ReverseList.reverse(null);
        Assert.assertNull(ret);
    }

    @Test
    public void reverseSingleNodeList() {
        ReverseList.ListNode<Integer> originalList = createNode(1);
        ReverseList.ListNode<Integer> ret = ReverseList.reverse(originalList);
        Assert.assertNotNull("应有一个元素,不应为空", ret);
        Assert.assertEquals(new Integer(1), ret.getValue());
    }

    @Test
    public void reverseCommonList() {
        int n = 12;
        ReverseList.ListNode<Integer> originalList = createNode(n);
        ReverseList.ListNode<Integer> ret = ReverseList.reverse(originalList);
        Assert.assertNotNull("应有" + n + "个元素,不应为空", ret);
        Assert.assertEquals(new Integer(1), ret.getValue());
        int count = 0;
        ReverseList.ListNode<Integer> cur = ret;
        while(null != cur) {
            count++;
            cur = cur.getNext();
        }
        Assert.assertEquals(n, count);
    }

    /**
     * ReverseList.ListNode<Integer> cur = test.createList(12);
     *
     * @param length
     * @return if length ≤ 0, return null
     */
    private ReverseList.ListNode<Integer> createList(int length) {
        if (length <= 0) {
            return null;
        }
        return createNode(length);
    }

    private ReverseList.ListNode<Integer> createNode(int value) {
        ReverseList.ListNode<Integer> node = new ReverseList.ListNode<>();
        node.setValue(value);
        if (value == 1) {
            node.setNext(null);
            return node;
        }
        node.setNext(createNode(value - 1));
        return node;
    }
}
