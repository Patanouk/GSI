package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int complement = target - number;

            if (numberToIndex.containsKey(complement)) {
                result[0] = numberToIndex.get(complement);
                result[1] = i;
                return result;
            }

            numberToIndex.put(number, i);
        }
        return result;
    }
}
