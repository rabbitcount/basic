package com.ocelot.basic.linklist;

import org.junit.Assert;
import org.junit.Test;

public class FindKthToTailTest {

    @Test
    public void listSizeLessThanK() {
        int length = 24;
        int k = 12;
        FindKthToTail.ListNode<Integer> head = createList(length);
        FindKthToTail.ListNode<Integer> ret = FindKthToTail.findKthToTailFacade(head, 12);
        Assert.assertNotNull("应查询结果为" + k + ", 实际为空", ret);
        Assert.assertEquals(new Integer(12), ret.getValue());
    }

    public void listSizeEqualsK() {

    }

    public void listSizeLargerThanK() {

    }

    /**
     * indKthToTail.ListNode<Integer> cur = test.createList(12);
     * @param length
     * @return if length ≤ 0, return null
     */
    private FindKthToTail.ListNode<Integer> createList(int length) {
        if(length <= 0) {
            return null;
        }
        return createNode(length);
    }

    private FindKthToTail.ListNode<Integer> createNode(int value) {
        FindKthToTail.ListNode<Integer> node = new FindKthToTail.ListNode<>();
        node.setValue(value);
        if(value == 1) {
            node.setNext(null);
            return node;
        }
        node.setNext(createNode(value - 1));
        return node;
    }
}
