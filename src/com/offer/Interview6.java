package com.offer;

import com.offer.datastruct.ListNode;

import java.util.LinkedList;
import java.util.Random;

/**
 * Page58:面试题6：从尾到头打印链表
 */
public class Interview6 {
    public static void main(String[] args) {
        Interview6 interview6 = new Interview6();
        ListNode node = interview6.createData();
        interview6.print(node);
        interview6.printNodeListReverse(node);
    }

    /**
     * 采用递归方式倒叙打印链表
     * @param linkedList 需要打印的链表
     */
    public void printNodeListReverse(ListNode linkedList) {
        printNode(linkedList);
    }

    private void printNode(ListNode next) {
        if (next.next != null) {
            printNode(next.next);
        }
        System.out.print(" <- " + next.value);
    }

    public ListNode createData() {
        Random random = new Random(System.currentTimeMillis());
        int max = 100;
        int size = 10;
        ListNode currentNode = new ListNode(random.nextInt(max));
        ListNode node = currentNode;
        for (int i = 0; i < size; i++) {
            ListNode newNode = new ListNode(random.nextInt(max));
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return node;
    }

    public void print(ListNode node) {
        ListNode currentNode = node;
        System.out.println(">>>");
        do {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        } while (currentNode!= null);
        System.out.println("\n<<<");
    }
}
