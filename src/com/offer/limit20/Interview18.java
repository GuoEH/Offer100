package com.offer.limit20;

import com.offer.datastruct.ListNode;

/**
 * Page119:面试题18：删除链表的节点
 */
public class Interview18 {
    public static void main(String[] args) {
        Interview18 interview18 = new Interview18();
        //题目一：在O(1)时间内删除链表节点
//        ListNode head = ListNode.createData(10);
//        ListNode.print(head);
//        ListNode random = ListNode.getRandomNode(head);
//        interview18.deleteNode(head, random);
//        ListNode.print(head);

        //题目二：删除链表中重复节点
        ListNode repeat = ListNode.createSortedData(10, 2);
        ListNode.print(repeat);
        interview18.deleteRepeatNode(repeat);
        ListNode.print(repeat);
    }

    /**
     * 题目一：以O(1)的时间复杂度删除链表中某个节点
     *
     * @param head    链表表头
     * @param current 要删除的接地那
     */
    public void deleteNode(ListNode head, ListNode current) {
        if (head == null || current == null) {
            return;
        }
        if (current.next != null) {
            //要删除的链表不是尾节点时
            current.value = current.next.value;
            current.next = current.next.next;
        } else if (current == head) {
            //链表只有一个节点时
            head = null;
            current = null;
        } else {
            //链表有多个节点，要删除尾节点时
            ListNode pre = head;
            while (pre.next != current) {
                pre = pre.next;
            }
            pre.next = null;
        }
    }

    /**
     * 题目二：删除链表中重复节点
     *
     * @param repeat 链表表头
     */
    public void deleteRepeatNode(ListNode repeat) {
    }

}
