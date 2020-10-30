package com.june.leetcode.tree;

import java.util.Stack;

public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1_1 = new TreeNode(2);
        TreeNode r1_2 = new TreeNode(3);

        TreeNode r1_1_1 = new TreeNode(4);
        TreeNode r1_1_2 = new TreeNode(5);

        TreeNode r1_2_1 = new TreeNode(6);
        TreeNode r1_2_2 = new TreeNode(7);

        TreeNode r1_1_1_1 = new TreeNode(8);
        TreeNode r1_1_1_2 = new TreeNode(9);

        root.left = r1_1;
        root.right = r1_2;

        r1_1.left = r1_1_1;
        r1_1.right = r1_1_2;

        r1_2.left = r1_2_1;
        r1_2.right = r1_2_2;

        r1_1_1.left = r1_1_1_1;
        r1_1_1.right = r1_1_1_2;


        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.first(root);

        System.out.println();
        treeTraverse.middle(root);

        System.out.println();
        treeTraverse.last(root);
    }

    public void first(TreeNode root) {
        System.out.println("==>>  先序遍历 Begin  ==");
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                System.out.print("  " + root.val + "  ");
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        System.out.println();
        System.out.println("==>>  先序遍历 End  ==");
    }

    public void middle(TreeNode root) {
        System.out.println("==>>  中序遍历 Begin  ==");
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print("  " + root.val + "  ");
            root = root.right;
        }
        System.out.println();
        System.out.println("==>>  中序遍历 End  ==");
    }

    public void last(TreeNode root) {
        System.out.println("==>>  后序遍历 Begin  ==");
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            boolean tag = true;
            TreeNode preNode = null;  // 前驱节点
            while (!stack.isEmpty() && tag) {
                root = stack.peek();
                if (root.right == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
                    root = stack.pop();
                    System.out.print("  " + root.val + "  ");
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = root;
                    }
                } else {
                    root = root.right;
                    tag = false;
                }
            }
        }
        System.out.println();
        System.out.println("==>>  后序遍历 End  ==");
    }
}
