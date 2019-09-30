package base;

public class Greedy {
    //122. 买卖股票的最佳时机 II
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 1)
            return profit;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
