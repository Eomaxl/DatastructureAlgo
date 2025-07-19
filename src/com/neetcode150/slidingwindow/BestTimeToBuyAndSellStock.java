package com.neetcode150.slidingwindow;
/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day. You may choose a single day
 * to buy one NeetCoin and choose a different day in the future to sell it. Return the maximum profit you can achieve. You may choose to not make any transactions,
 * in which case the profit would be 0.
 * Example 1 : Input prices = [10,1,5,6,7,1], Output : 6
 * Example 2:  Input: prices = [10,8,7,5,2], Output : 0
 * */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices1 = {10 , 1, 5, 6, 7, 1};
        int[] prices2 = { 10, 8, 7,5, 2};
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfitUsingDP(prices1));
        System.out.println(obj.maxProfitUsingTwoPointers(prices2));
    }
    public int maxProfitByBruteForce(int[] prices){
        int res = 0;
        for (int i =0; i < prices.length; i++){
            int buy = prices[i];
            for (int j = i+1; j < prices.length; j++){
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }
        return res;
    }

    public int maxProfitUsingTwoPointers(int[] prices){   // TC :O(n), SC: O(1)
        int l =0, r =1;
        int maxProfit = 0;

        while (r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }

    public int maxProfitUsingDP(int[] prices){ // TC: O(n), SC: O(1)
        int maxProfit = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxProfit = Math.max(maxProfit, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }

        return maxProfit;
    }
}
