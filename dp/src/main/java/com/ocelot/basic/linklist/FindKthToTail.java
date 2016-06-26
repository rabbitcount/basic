package com.ocelot.basic.linklist;

import java.util.Objects;

public class FindKthToTail {

    /**
     * to find the kth node to tail
     * 查找倒数第k个节点
     *
     * 外围方法用于参数过滤
     *
     * 双指针
     * @param head
     * @param k
     * @return the Kth node to tail. 倒数第k个节点
     */
    public static <T> ListNode<T> findKthToTailFacade(ListNode<T> head, long k) {
        if(k <= 0) {
            return null;
        }
        return findKthToTail(head, k);
    }

    private static <T> ListNode<T> findKthToTail(ListNode<T> cur, long k) {
        ListNode<T> firstNode = cur; // 首指针
        ListNode<T> secondNode = cur; // 跟随指针
        // first指针向前移动k位
        for(long first = 0;first < k; first++) {
            if(Objects.isNull(firstNode)) {
                return firstNode;
            }
            firstNode = firstNode.getNext();
        }
        while(true) {
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext();
            if(Objects.isNull(firstNode)) {
                break;
            }
        }
        return secondNode;
    }

    public static class ListNode<T> {
        private T value;
        ListNode<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }
    }
}
