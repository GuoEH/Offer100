package com.offer.limit10;

import com.offer.datastruct.ListNode;

/**
 * Page58:面试题6：从尾到头打印链表
 */
public class Interview6 {
    public static void main(String[] args) {
        Interview6 interview6 = new Interview6();
        ListNode node = ListNode.createData(9);
        ListNode.print(node);
        interview6.printNodeListReverse(node);
    }

    /**
     * 采用递归方式倒叙打印链表
     * @param linkedList 需要打印的链表
     */
    public void printNodeListReverse(ListNode linkedList) {
        if (linkedList == null){
            System.out.println("链表为空");
            return;
        }
        printNode(linkedList);
    }

    private void printNode(ListNode next) {
        if (next.next != null) {
            printNode(next.next);
        }
        System.out.print(" <- " + next.value);
    }
}
