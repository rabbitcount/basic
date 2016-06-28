package com.ocelot.basic.linklist;


import java.util.Objects;

public class ReverseList {

    /**
     *
     * @param head
     * @param <T>
     * @return return
     */
    public static <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        while(cur != null) {
            ListNode<T> next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
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
