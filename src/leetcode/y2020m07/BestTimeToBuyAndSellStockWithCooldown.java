package leetcode.y2020m07;

/**
 * @author whx
 * 解题思路：https://www.yuque.com/docs/share/c5ec0199-fae8-4e32-ab5d-2977b617fe18?# 《LeetCode 309 最佳买卖股票时机含冷冻期》
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices){
        int getProfitMinDay=2;
        if ( prices == null || prices.length < getProfitMinDay){
            return 0;
        }
        int [][]dp =new int [prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(-prices[0],-prices[1]);
        dp[1][1] =Math.max(dp[0][0]+prices[1],0);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-2][1]-prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(test.maxProfit(new int[]{2, 1}));
    }
}
