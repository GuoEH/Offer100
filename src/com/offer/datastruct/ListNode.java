package com.offer.datastruct;

import java.util.Random;
import java.util.Stack;

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
        return createData(size, 100);
    }

    /**
     * 生成一个随机链表
     * @param size 链表长度
     * @param range 节点至范围
     * @return 生成的链表
     */
    public static ListNode createData(int size, int range) {
        Random random = new Random(System.currentTimeMillis());
        ListNode currentNode = new ListNode(random.nextInt(range));
        ListNode node = currentNode;
        for (int i = 0; i < size - 1; i++) {
            ListNode newNode = new ListNode(random.nextInt(range));
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return node;
    }

    /**
     * 生成一个按序增长的链表
     * @param size 链表长度
     * @param step 步长
     * @return 生成的链表
     */
    public static ListNode createSortedData(int size, int step) {
        Random random = new Random(System.currentTimeMillis());
        int value = random.nextInt(step);
        ListNode currentNode = new ListNode(value);
        ListNode node = currentNode;
        for (int i = 0; i < size - 1; i++) {
            value += random.nextInt(step);
            ListNode newNode = new ListNode(value);
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return node;
    }

    /**
     * 遍历方式打印链表
     *
     * @param node 头节点
     */
    public static void print(ListNode node) {
        ListNode currentNode = node;
        System.out.println(">>>");
        do {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.print("null");
        System.out.println("\n<<<");
    }

    /**
     * 获取链表中随机一个节点
     *
     * @param head 头指针
     * @return 随机节点
     */
    public static ListNode getRandomNode(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int size = 0;
        while (current != null) {
            stack.push(current);
            current = current.next;
            size++;
        }
        Random random = new Random(System.currentTimeMillis());
        int r = random.nextInt(size + 1);
        System.out.print("第 " + (size - r) + " 个");
        for (int i = 0; i < r; i++) {
            current = stack.pop();
        }
        if (current == null) {
            current = stack.peek();
        }
        System.out.println(" value = " + current.value);
        return current;
    }
}
