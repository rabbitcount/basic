package com.ocelot.basic.base;

import com.ocelot.basic.linklist.ReverseList;

public class LinkedListNode<T> {

    private T value;
    ReverseList.ListNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ReverseList.ListNode<T> getNext() {
        return next;
    }

    public void setNext(ReverseList.ListNode<T> next) {
        this.next = next;
    }
}
