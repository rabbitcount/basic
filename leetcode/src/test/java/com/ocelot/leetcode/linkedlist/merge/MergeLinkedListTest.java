package com.ocelot.leetcode.linkedlist.merge;

import com.ocelot.leetcode.linkedlist.LinkedListNode;
import com.ocelot.leetcode.linkedlist.LinkedListUtils;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaoxiang on 2016/12/31.
 */
public class MergeLinkedListTest {

    @Test
    public void testMergeTwoAllNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(null, null);
        assertTrue(Objects.isNull(result));
    }

    @Test
    public void testMergeTwoFirstListIsNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(null, LinkedListUtils.createSortedList(1));
        assertEquals(1, LinkedListUtils.getLength(result));
        assertTrue(LinkedListUtils.isSorted(result));
    }

    @Test
    public void testMergeTwoSecondListIsNull() {
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(LinkedListUtils.createSortedList(1), null);
        assertEquals(1, LinkedListUtils.getLength(result));
        assertTrue(LinkedListUtils.isSorted(result));
    }

    @Test
    public void testMergeTwoMergeWithRandomList() {
        int M = LinkedListUtils.randomGenerateIntValue();
        int N = LinkedListUtils.randomGenerateIntValue();
        LinkedListNode<Integer> result = MergeLinkedList.mergeTwoLists(LinkedListUtils.createSortedList(M), LinkedListUtils.createSortedList(N));
        assertEquals(M + N, LinkedListUtils.getLength(result));
        assertTrue(LinkedListUtils.isSorted(result));
    }

    @Test
    public void testMergeKListsWithRandomLists() {
        int n = LinkedListUtils.randomGenerateIntValue();
        LinkedListNode<Integer>[] lists = new LinkedListNode[n];
        int sum = 0;
        for (int index = 0; index < n; index++) {
            int positionLength = LinkedListUtils.randomGenerateIntValue();
            sum += positionLength;
            lists[index] = LinkedListUtils.createSortedList(positionLength);
        }
        LinkedListNode<Integer> result = MergeLinkedList.mergeKLists(lists);
        assertEquals(sum, LinkedListUtils.getLength(result));
        assertTrue(LinkedListUtils.isSorted(result));
    }

}
