package leetcode.y2020m07;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //便利一遍算每个点的收益最多的时刻
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<buyPrice){
                //更新一下最大收益
                maxProfit=Math.max(prices[i]-buyPrice,maxProfit);
                //更新买入价格、卖出价格和对应天数
                buyPrice=prices[i];
            }else if (prices[i]-buyPrice>maxProfit){
                maxProfit=prices[i]-buyPrice;
            }
        }
        return maxProfit;
    }
}
