package com.june.leetcode.linear.array;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * 2021年3月29日19:16:39
 *
 * 总结：
 * 主要是利用指定区间的数组反转达到旋转的目的，注意旋转系数k的取值范围和判断
 * 第一次：旋转整个数组
 * 第二次：将旋转区域再次进行旋转，以保证旋转过来的序列
 * 第三次：将不需要旋转的区域恢复成原本的序列
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotate(numbers1, 3)));
        int[] numbers2 = new int[]{-1, -100, 3, 99};
        System.out.println(Arrays.toString(rotate(numbers2, 2)));
    }

    public static int[] rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0 || k == nums.length) return nums;

        if (k > nums.length) {
            k =  k % nums.length;
        }

        if(nums.length == 2){
            reverseArray(nums, 0, nums.length - 1);
            return nums;
        }

        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        return nums;
    }

    public static void reverseArray(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
