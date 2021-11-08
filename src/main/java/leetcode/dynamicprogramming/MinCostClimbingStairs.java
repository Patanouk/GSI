package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100}));
    }
}
