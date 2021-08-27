package com.june.leetcode.linear.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMiddleInTwoArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (null == nums1 && null == nums2) return 0;
        if (null == nums1) {
            int middle = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                // 偶数序列
                return (nums2[middle] + nums2[middle + 1]) / 2.0;
            } else {
                // 奇数序列
                return nums2[middle] * 1.0;
            }
        }
        if (null == nums2) {
            int middle = nums1.length / 2;
            if (nums1.length % 2 == 0) {
                // 偶数序列
                return (nums1[middle] + nums1[middle + 1]) / 2.0;
            } else {
                // 奇数序列
                return nums1[middle] * 1.0;
            }
        }

        List<Integer> list = new ArrayList<>();
        // 插入排序
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }
        Collections.sort(list);
        int middle = list.size() / 2;
        if (list.size() % 2 == 0) {
            // 偶数序列
            return (list.get(middle) + list.get(middle - 1)) / 2.0;
        } else {
            // 奇数序列
            return list.get(middle) * 1.0;
        }
    }
}
