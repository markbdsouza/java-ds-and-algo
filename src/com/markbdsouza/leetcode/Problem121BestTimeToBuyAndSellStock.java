package com.markbdsouza.leetcode;


/**
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Level: Easy
 * Tags: Array
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class Problem121BestTimeToBuyAndSellStock {

    /*
     * @param prices - list of integers with prices in random order
     * @return max price
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        /* We are calculating the difference between that element and
        * the minimum of all the values before that element
        * and we are updating the maximum profit
        * if the difference thus found is greater than the current maximum profit.
         */
        int tempMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // check if there is a new max Profit, if so replace
            if (maxProfit < prices[i] - tempMin) maxProfit = prices[i] - tempMin;
            // See if there is a new min from 0th index to i. If yes, replace
            if (prices[i] < tempMin) tempMin = prices[i];
        }
        return maxProfit;
    }

}
