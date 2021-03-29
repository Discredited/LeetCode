package com.june.leetcode.linear.array;

/**
 * 136.只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        // 异或运算
        // 任何数和 00 做异或运算，结果仍然是原来的数，即a⊕0=a。
        // 任何数和其自身做异或运算，结果是0，即 a⊕a=0。
        // 异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b

        int single = 0;
        for (int number : nums) {
            single = single ^ number;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 1, 3, 3, 5, 6, 6};
        System.out.println("只出现一次的数字:" + singleNumber(numbers1));
        int[] numbers2 = new int[]{0, 1, 1, 3, 3};
        System.out.println("只出现一次的数字:" + singleNumber(numbers2));
        int[] numbers3 = new int[]{1, 1, 3, 3};
        System.out.println("只出现一次的数字:" + singleNumber(numbers3));
    }
}
