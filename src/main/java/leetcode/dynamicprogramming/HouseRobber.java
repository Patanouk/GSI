package leetcode.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 2] + nums[i], maxMoney[i - 1]);
        }

        return Math.max(maxMoney[maxMoney.length - 1], maxMoney[maxMoney.length - 2]);
    }
}
