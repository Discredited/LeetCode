package com.june.leetcode.linear.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 * https://leetcode-cn.com/problems/majority-element-ii/
 * <p>
 * 2021年10月22日17:03:15
 */
public class FindMajorityElement {

    public static void main(String[] args) {
        System.out.println("[3,2,3]==>>" + majorityElement(new int[]{3,2,3}));
    }

    /**
     * 暴力解法 哈希散列
     *
     * 10 ms	41.8 MB
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (null == nums) return list;

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        int frequency = nums.length / 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number : nums) {
            if (map.containsKey(number)) {
                int count = map.get(number);
                map.put(number, ++count);
            } else {
                map.put(number, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > frequency){
                list.add(entry.getKey());
            }
        }

        return list;
    }

    /**
     * 摩尔投票法
     */
}
