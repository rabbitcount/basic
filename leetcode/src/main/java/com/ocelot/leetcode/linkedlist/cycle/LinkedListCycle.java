package com.ocelot.leetcode.linkedlist.cycle;

import com.ocelot.leetcode.linkedlist.LinkedListNode;

/**
 * Question：
 *  Given a linked list, determine if it has a cycle in it.
 *  Follow up: Can you solve it without using extra space?
 *
 * Solution in leetcode
 *  https://discuss.leetcode.com/topic/12516/o-1-space-solution
 *
 * Tip:
 *  使用两个指针，一个每次走两步，一个每次走一步，如果一段时间之后这两个指针能重合，那么铁定存在环了
 */
public class LinkedListCycle {

    /**
     * 判断链表是否有环
     *
     * @param head 可为空
     * @return
     */
    public static boolean hasCycle(LinkedListNode head) {
        if(null == head) {
            return false;
        }
        LinkedListNode runner = head;
        LinkedListNode walker = head;
        // 隐含条件，runner已经判断所有节点都不是null，所以walker不需要再次判空
        while(null != runner.getNext() && null != runner.getNext().getNext()) {
            walker = walker.getNext();
            runner = runner.getNext().getNext();
            if(walker == runner) {
                return true;
            }
        }
        return false;
    }
}
