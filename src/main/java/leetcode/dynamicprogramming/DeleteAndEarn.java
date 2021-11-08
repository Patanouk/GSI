package leetcode.dynamicprogramming;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/delete-and-earn/
 * <p>
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * <p>
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> numCount = new TreeMap<>();
        for (int num : nums) {
            numCount.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        int avoid = 0;
        int using = 0;
        int previous = -1;
        for (Integer num : numCount.keySet()) {
            int temp = using;
            if (num - 1 == previous) {
                using = avoid + numCount.get(num) * num;
            } else {
                using = Math.max(avoid, using) + numCount.get(num) * num;
            }

            avoid = Math.max(avoid, temp);
            previous = num;
        }

        return Math.max(using, avoid);
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
