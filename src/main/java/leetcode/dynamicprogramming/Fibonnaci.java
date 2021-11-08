package leetcode.dynamicprogramming;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */
public class Fibonnaci {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] fibNumbers = new int[n + 1];

        fibNumbers[0] = 0;
        fibNumbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }

        return fibNumbers[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
