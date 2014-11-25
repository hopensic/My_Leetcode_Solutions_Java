package leetcode;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] A = { -2, 1 };
		System.out.println(new MaximumSubarray().maxSubArray(A));
	}

	public int maxSubArray(int[] A) {
		int max = 0;
		int maxmax;
		int sum = 0;
		int len = A.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return A[0];
		maxmax = A[0];
		for (int i = 0; i < len; i++) {
			if (A[i] > maxmax)
				maxmax = A[i];
			sum += A[i];
			if (sum > max)
				max = sum;
			else if (sum < 0)
				sum = 0;
		}
		if (maxmax <= 0)
			return maxmax;
		return max;
	}
}
