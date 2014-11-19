package leetcode;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int value = 0;
		int maxValue = 0;
		int len = prices.length;
		if (len == 0 || len == 1)
			return 0;
		int t1, t2;
		for (int i = 0; i < len && i + 1 < len; i++) {
			t1 = prices[i];
			t2 = prices[i + 1];
			value = t2 - t1;
			if (value <= 0)
				value = 0;
			maxValue += value;
		}
		return maxValue;
	}
}
