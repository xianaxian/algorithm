package leetcode.y2021m02;

/**
 * @author whx
 */
public class CoinChange {
    public static void main(String[] args) {
        //[186,419,83,408]
        //6249
        int[] a = new int[]{186, 419, 83, 408};
        CoinChange coinChange = new CoinChange();
//        System.out.println(coinChange.error2CoinChange(a, 6249));
        System.out.println(coinChange.coinChange(a, 6249));
    }

    //step 1
    public int errorCoinChange(int[] coins, int amount) {
        coins = reorderCoins(coins);
        int number = 0;
        while (amount != 0) {
            if (coins[coins.length - 1] > amount) {
                return -1;
            }
            for (int coin : coins) {
                if (amount >= coin) {
                    amount = amount - coin;
                    number++;
                    break;
                }
            }
        }
        return number;
    }

    /**
     * 递归实现容易超时
     */
    private int res = Integer.MAX_VALUE;

    public int error2CoinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findMinCount(coins, amount, 0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findMinCount(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            findMinCount(coins, amount - coins[i], count + 1);
        }
    }

    int[] memo;

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return findWay(coins, amount);
    }

    /**
     * memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
     * findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
     */

    public int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
                // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];
        memo[0] = 0;
        return nextCoinChange(coins, amount);
    }

    /**
     * 不知道写错了哪里，以后再看
     */
    public int nextCoinChange(int[] coins, int amount) {


        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int nextResult = nextCoinChange(coins, amount - coin);
            if (nextResult > 0) {
                min = Math.min(min, nextResult + 1);
            }
        }
        int result;
        if (min == Integer.MAX_VALUE) {
            result = -1;
        } else {
            result = min;
        }
        memo[amount] = result;
        return result;
    }

    private int[] reorderCoins(int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            for (int j = i; j < coins.length; j++) {
                if (coins[i] < coins[j]) {
                    int temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;

                }
            }
        }
        return coins;
    }
}
