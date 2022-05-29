package com.markbdsouza.leetcode;


/**
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Level: Easy
 * Tags: Array
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
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
