package com.offer.datastruct;

import java.util.Random;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    /**
     * 创建一个二叉树
     * 1
     * /  \
     * 2    5
     * /  \
     * 3    4
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

    private static BinaryTreeNode createNode(BinaryTreeNode root, int[] src, int i) {
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
        System.out.print(node.value + (node.parent == null ? " " : "(" + node.parent.value + ") "));
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
        System.out.print(node.value + (node.parent == null ? " " : "(" + node.parent.value + ") "));

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

        System.out.print(node.value + (node.parent == null ? " " : "(" + node.parent.value + ") "));
    }

    public static void printCombine(BinaryTreeNode root) {
        printPre(root);
        printIn(root);
        printPost(root);
    }

    public static BinaryTreeNode createDataByPreIn(int[] pre, int[] in, int length) {
        if (pre == null || in == null || length <= 0 || pre.length != length || in.length != length) {
            return null;
        }

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1, null);
    }

    private static BinaryTreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, BinaryTreeNode parent) {
        int rootValue = pre[preStart];
        BinaryTreeNode node = new BinaryTreeNode(rootValue);
        node.parent = parent;
        if (preStart == preEnd) {
            return node;
        }

        int inRootIndex = indexOf(in, rootValue, inStart);
        if (inRootIndex == -1) {
            throw new IllegalArgumentException("前序与中序不匹配");
        }
        int inLeftEnd = inRootIndex - 1;
        int inLeftLength = inLeftEnd - inStart + 1;
        int preLeftStart = preStart + 1;
        int preLeftEnd = preLeftStart + inLeftLength - 1;
        if (inLeftLength > 0) {
            node.left = construct(pre, preLeftStart, preLeftEnd, in, inStart, inLeftEnd, node);
        }

        int inRightStart = inRootIndex + 1;
        int preRightStart = preLeftEnd + 1;
        int preRightLength = preEnd - preRightStart + 1;
        if (preRightLength > 0) {
            node.right = construct(pre, preRightStart, preEnd, in, inRightStart, inEnd, node);
        }

        return node;
    }

    private static int indexOf(int[] array, int value, int from) {
        while (array[from] != value) {
            from++;
        }
        return from;
    }

    public static BinaryTreeNode getRandomNode(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode node = root;
        Random random = new Random(System.currentTimeMillis());
        int i = 0;
        boolean finish = false;
        while (!finish) {
            i = random.nextInt(3);
            if (i == 0) {
                finish = true;
            } else if (i == 1) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    finish = true;
                }
            } else if (i == 2) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    finish = true;
                }
            }
        }
        return node;
    }

    @Override
    public String toString() {
        return "{value=" + value +
                "[l=" + (left == null ? "null" : left.value) +
                ",r=" + (right == null ? "null" : right.value) +
                ",p=" + (parent == null ? "null" : parent.value) +
                "]}";
    }
}
