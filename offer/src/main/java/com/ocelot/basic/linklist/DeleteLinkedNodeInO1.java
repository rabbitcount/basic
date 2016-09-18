package com.ocelot.basic.linklist;

import com.ocelot.basic.base.LinkedListNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 13
 * Q: 给定单向链表的头指针和一个节点指针, 定义一个函数在O(1)时间删除该节点。
 * A: 实际关注点,需要将指向待删除节点的指针执行待删除节点的后继节点, 在单向链表中, 遍历的方法不能再常数时间内获得待删除节点的前序节点。
 *    解决方法: 将待删除节点的后继节点的值付给待删除节点。然后实际删除待删除节点的后继节点。
 */
public class DeleteLinkedNodeInO1 {

    public static void doDelete(LinkedListNode<T> head, LinkedListNode<T> cur) {
        if(Objects.isNull(cur) || Objects.isNull(cur.getNext())) {
            return;
        }
        // 将后继节点的值付给当前节点
        cur.setValue(cur.getNext().getValue());
        // 删除待删除节点的后继节点
        cur.setNext(cur.getNext().getNext());
    }
}
