package com.hunter.study.leetcode.d0515;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 水木
 * @Date 2020/5/15  12:44 下午
 */
public class TwoNumbersAdd {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum1(nums, target);

        System.out.println(Arrays.toString(ints));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 利用hashMap ,将查找的时间复杂度变为O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[] {hashMap.get(num), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

}
