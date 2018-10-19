package com.offer.limit10;

import com.offer.datastruct.BinaryTreeNode;

/**
 * Page65：面试题8：二叉树的下一个节点
 */
public class Interview8 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        BinaryTreeNode root = BinaryTreeNode.createDataByPreIn(pre, in, pre.length);
        BinaryTreeNode.printCombine(root);
        Interview8 interview8 = new Interview8();
        BinaryTreeNode current = BinaryTreeNode.getRandomNode(root);
        System.out.println("当前节点是：" + current);
        BinaryTreeNode next = interview8.nextInNode(current);
        System.out.println("下一个节点是:" + next);
    }

    /**
     * 找到该二叉树中中序遍历的下一个节点
     *
     * @param current 当前节点
     * @return 中序遍历的下一个节点
     */
    private BinaryTreeNode nextInNode(BinaryTreeNode current) {
        if (current == null) {
            return null;
        }
        BinaryTreeNode next = null;
        if (current.right != null) {
            BinaryTreeNode right = current.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        } else if (current.parent != null) {
            BinaryTreeNode cur = current;
            BinaryTreeNode parent = current.parent;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }
}
