package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * You are a professional robber planning to rob houses along a street
 * Each house has a certain amount of money stashed
 * All houses at this place are arranged in a circle
 * That means the first house is the neighbor of the last one
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] firstPossible = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] secondPossible = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(maxRobLinear(firstPossible), maxRobLinear(secondPossible));
    }

    private int maxRobLinear(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + nums[i]);
        }

        return maxRob[maxRob.length - 1];
    }
}
