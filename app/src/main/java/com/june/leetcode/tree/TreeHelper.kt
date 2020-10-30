package com.june.leetcode.tree

object TreeHelper {

    @JvmStatic
    fun getTrees(): TreeNode {
        val root = TreeNode(1)
        val r1_1 = TreeNode(2)
        val r1_2 = TreeNode(3)

        val r1_1_1 = TreeNode(4)
        val r1_1_2 = TreeNode(5)

        val r1_2_1 = TreeNode(6)
        val r1_2_2 = TreeNode(7)

        val r1_1_1_1 = TreeNode(8)
        val r1_1_1_2 = TreeNode(9)

        root.left = r1_1
        root.right = r1_2

        r1_1.left = r1_1_1
        r1_1.right = r1_1_2

        r1_2.left = r1_2_1
        r1_2.right = r1_2_2

        r1_1_1.left = r1_1_1_1
        r1_1_1.right = r1_1_1_2

        return root
    }
}