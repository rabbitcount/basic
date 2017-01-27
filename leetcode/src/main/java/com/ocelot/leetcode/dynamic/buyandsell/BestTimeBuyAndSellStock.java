package com.ocelot.leetcode.dynamic.buyandsell;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/27.
 */
public class BestTimeBuyAndSellStock {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction
     * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * 这是卖股票的第一个题目，根据题意我们知道只能进行一次交易，但需要获得最大的利润，所以我们需要在最低价买入，最高价卖出，当然买入一定要在卖出之前。
     * 对于这一题，还是比较简单的，我们只需要遍历一次数组，通过一个变量记录当前最低价格，同时算出此次交易利润，并与当前最大值比较就可以了。
     *
     * maxCur = current maximum value
     * maxSoFar = maximum value found so far
     */
    public static final int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
