package com.offer.datastruct;

import java.util.Random;

/**
 * 链表的一个节点
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    public static ListNode createData(int size) {
        Random random = new Random(System.currentTimeMillis());
        int max = 100;
        ListNode currentNode = new ListNode(random.nextInt(max));
        ListNode node = currentNode;
        for (int i = 0; i < size - 1; i++) {
            ListNode newNode = new ListNode(random.nextInt(max));
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return node;
    }

    /**
     * 遍历方式打印链表
     * @param node 头节点
     */
    public static void print(ListNode node) {
        ListNode currentNode = node;
        System.out.println(">>>");
        do {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        } while (currentNode!= null);
        System.out.println("\n<<<");
    }
}
