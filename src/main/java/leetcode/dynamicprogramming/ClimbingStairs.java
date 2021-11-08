package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] distinctWays = new int[n + 1];
        distinctWays[0] = 0;
        distinctWays[1] = 1;
        distinctWays[2] = 2;

        for (int i = 3; i <= n; i++) {
            distinctWays[i] = distinctWays[i - 1] + distinctWays[i - 2];
        }

        return distinctWays[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
