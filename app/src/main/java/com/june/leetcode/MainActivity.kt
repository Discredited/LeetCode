package com.june.leetcode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.june.leetcode.linear.array.MinStoneSum
import com.june.leetcode.linear.link.ListNode
import com.june.leetcode.linear.link.MergeTwoSortedLinkedList
import com.june.leetcode.string.RomanToInt

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // val node1 = ListNode(1, ListNode(2, ListNode(4)))
    // val node2 = ListNode(1, ListNode(3, ListNode(4)))
    //
    // val newNode = MergeTwoSortedLinkedList.mergeTwoLists(node1, node2)
    // if (null == newNode) {
    //     Log.e("June", "[]")
    // } else {
    //     Log.e("June", newNode.printNode())
    // }

//    Log.e("June", "结果是：${RomanToInt().romanToInt("LVIII")}")

      MinStoneSum().minStoneSum(intArrayOf(5,4,9),2)
  }
}