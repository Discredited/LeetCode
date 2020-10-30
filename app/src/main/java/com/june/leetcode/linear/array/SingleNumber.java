package com.june.leetcode.linear.array;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int number : nums) {
//            int index = list.indexOf(number);
//            if (index >= 0) {
//                list.remove(index);
//            } else {
//                list.add(number);
//            }
//        }
//        return list.get(0);

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
}
