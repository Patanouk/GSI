package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 */
public class Tribonnaci {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n ==2) {
            return 1;
        }

        int[] tribonnaciNumbers = new int[n + 1];
        tribonnaciNumbers[0] = 0;
        tribonnaciNumbers[1] = 1;
        tribonnaciNumbers[2] = 1;

        for (int i = 3; i <= n; i++) {
            tribonnaciNumbers[i] = tribonnaciNumbers[i - 1] + tribonnaciNumbers[i - 2] +tribonnaciNumbers[i - 3];
        }

        return tribonnaciNumbers[n];
    }
}
