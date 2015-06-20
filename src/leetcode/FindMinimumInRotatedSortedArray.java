package leetcode;

import tools.P;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 9, 8, 7, 6, 10 };
		int a = new FindMinimumInRotatedSortedArray().findMin(nums);
		P.lnrint(a);

	}

	public int findMin(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];
		else if (nums[0] < nums[1]) {
			for (int i = 0; i < len - 1; i++)
				if (nums[i + 1] < nums[i])
					return nums[i + 1];
			return nums[0];

		} else {
			for (int i = 0; i < len - 1; i++)
				if (nums[i + 1] > nums[i])
					return nums[i];
			return nums[len - 1];

		}
	}

}
