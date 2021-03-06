package cn.croff.dynamicprograming;

/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 先写出状态转移方程，再用DP优化，去除重复计算
        if (amount == 0) return 0;
        int[] records = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i < coin) continue;
                int previousRecord = records[i - coin];
                if (previousRecord < 0) continue;
                int newRecord = 1 + previousRecord;
                if (min == -1 || newRecord < min) min = newRecord;
            }
            records[i] = min;
        }
        return records[amount];
    }
}
