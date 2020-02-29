/*
https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class CoinChange {

    public static int count(int totalChange, int[] possibleCoins) {
        return count(totalChange, possibleCoins.length, possibleCoins);
    }

    private static int count(int remainingChange, int nCoin, int[] possibleCoins) {
        if (remainingChange < 0) {
            return 0;
        }

        if (remainingChange == 0) {
            return 1;
        }

        if (nCoin == 0 && remainingChange > 0) {
            return 0;
        }

        return count(remainingChange, nCoin - 1, possibleCoins)
                + count(remainingChange - possibleCoins[nCoin - 1], nCoin, possibleCoins);
    }
}
