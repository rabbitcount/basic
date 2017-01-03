package com.ocelot.leetcode.linkedlist;

import java.util.Objects;

/**
 * Created by gaoxiang on 2016/12/25.
 * 链表节点
 */
public class LinkedListNode<T extends Comparable<T> > {

    private T value = null;
    private LinkedListNode<T> next = null;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
