package com.offer.datastruct;

import java.util.Random;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    /**
     * 创建一个二叉树
     *              1
     *             /  \
     *            2    5
     *           /  \
     *          3    4
     *
     * @return 构建的二叉树
     */
    public static BinaryTreeNode createData() {
        Random random = new Random(System.currentTimeMillis());
        int max = 100;
        int size = 8;
        int[] src = {1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 0};
        BinaryTreeNode root = new BinaryTreeNode();
        root = createNode(root, src, counter);
        return root;
    }

    private static int counter = 0;//定义一个静态计数变量

    private  static BinaryTreeNode createNode(BinaryTreeNode root, int[] src, int i) {
        if (i < src.length) {
            if (src[i] == 0) {
                root = null;
            } else {
                BinaryTreeNode lchild = new BinaryTreeNode();
                BinaryTreeNode rchild = new BinaryTreeNode();
                root.value = src[i];
                root.left = createNode(lchild, src, ++counter);
                root.right = createNode(rchild, src, ++counter);
            }
        }
        return root;
    }

    public static void printIn(BinaryTreeNode root) {
        System.out.println("中序遍历结果:");
        printInNode(root);
        System.out.println();
    }

    private static void printInNode(BinaryTreeNode node) {
        if (node.left != null) {
            printInNode(node.left);
        }
        System.out.print(node.value + " ");
        if (node.right != null) {
            printInNode(node.right);
        }

    }

    public static void printPre(BinaryTreeNode root) {
        System.out.println("前序遍历结果:");
        printPreNode(root);
        System.out.println();

    }

    private static void printPreNode(BinaryTreeNode node) {
        System.out.print(node.value + " ");

        if (node.left != null) {
            printPreNode(node.left);
        }

        if (node.right != null) {
            printPreNode(node.right);
        }

    }

    public static void printPost(BinaryTreeNode root) {
        System.out.println("后序遍历结果:");
        printPostNode(root);
        System.out.println();

    }

    private static void printPostNode(BinaryTreeNode node) {
        if (node.left != null) {
            printPostNode(node.left);
        }

        if (node.right != null) {
            printPostNode(node.right);
        }

        System.out.print(node.value + " ");
    }
}
