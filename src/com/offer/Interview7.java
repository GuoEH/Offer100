package com.offer;

import com.offer.datastruct.BinaryTreeNode;

import java.util.Random;

/**
 * Page62：面试题7：重建二叉树
 */
public class Interview7 {
    public static void main(String[] args) {
        Interview7 interview7 = new Interview7();

        // 普通二叉树
//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        // 所有结点都没有右子结点
//        int[] pre = {1, 2, 3, 4, 5};
//        int[] in={5, 4, 3, 2, 1};

        // 所有结点都没有左子结点
//        int[] pre = {1, 2, 3, 4, 5};
//        int[] in={1, 2, 3, 4, 5};

        // 完全二叉树
//        int[] pre = {1, 2, 4, 5, 3, 6, 7};
//        int[] in= {4, 2, 5, 1, 6, 3, 7};

        // 输入的两个序列不匹配
        // TODO：修复不匹配的情况
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in= {4, 2, 8, 1, 6, 3, 7};

        BinaryTreeNode root = interview7.construct(pre, in, pre.length);

        BinaryTreeNode.printPre(root);
        BinaryTreeNode.printIn(root);
        BinaryTreeNode.printPost(root);

    }

    public BinaryTreeNode construct(int[] pre, int[] in, int length) {
        if (pre == null || in == null || length <= 0 || pre.length != length || in.length != length) {
            return null;
        }

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private BinaryTreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        System.out.println("pre = [" + preStart + "," + preEnd + "], in = [" + inStart + "," + inEnd + "]");
        int rootValue = pre[preStart];
        BinaryTreeNode node = new BinaryTreeNode(rootValue);
        if (preStart == preEnd) {
            return node;
        }

        int inRootIndex = indexOf(in, rootValue, inStart);
        if (inRootIndex==-1){
            throw new IllegalArgumentException("前序与中序不匹配");
        }
        int inLeftEnd = inRootIndex - 1;
        int inLeftLength = inLeftEnd - inStart + 1;
        int preLeftStart = preStart + 1;
        int preLeftEnd = preLeftStart + inLeftLength - 1;
        if (inLeftLength > 0) {
            node.left = construct(pre, preLeftStart, preLeftEnd, in, inStart, inLeftEnd);
        }

        int inRightStart = inRootIndex + 1;
        int preRightStart = preLeftEnd + 1;
        int preRightLength = preEnd - preRightStart + 1;
        if (preRightLength > 0) {
            node.right = construct(pre, preRightStart, preEnd, in, inRightStart, inEnd);
        }

        return node;
    }

    private int indexOf(int[] array, int value, int from) {
        while (array[from] != value) {
            from++;
        }
        return from;
    }
}