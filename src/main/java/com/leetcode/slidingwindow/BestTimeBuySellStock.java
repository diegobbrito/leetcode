package com.leetcode.slidingwindow;

public class BestTimeBuySellStock {
	//	https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

	//	Time Complexity O(n2)
	//	Space Complexity O(1)
	public int maxProfit(int[] prices) {
		int sell = 0;
		int length = prices.length;
		for(int i = 0; i < length - 1; i++){
			int buy = prices[i];
			int max = prices[i];
			for(int j = i + 1; j < length; j++){
				if(prices[j] > max){
					max = prices[j];
				}
			}
			if(sell < max - buy){
				sell = max - buy;
			}

		}
		return sell;
	}

	//	Time Complexity O(n)
	//	Space Complexity O(1)
	public int maxProfit2(int[] prices) {
		int length = prices.length;
		int buy = 0;
		int maxProfit = 0;
		for (int sell = 1; sell < length; sell++) {
			if (prices[buy] > prices[sell])
				buy = sell;
			else if (prices[sell] - prices[buy] > maxProfit)
				maxProfit = prices[sell] - prices[buy];
		}
		return maxProfit;
	}
}
