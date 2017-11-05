package leetcode;

import java.util.Arrays;

import leetcode.common.tree.TreeNode;

public class Maximum_Binary_Tree {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 2, 1, 6, 0, 5 };
		TreeNode node = new Maximum_Binary_Tree().constructMaximumBinaryTree(arr);
		System.out.println(Arrays.binarySearch(arr, 3));
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode rootNode = null;
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		} else {
			int[] temArray = nums.clone();
			Arrays.sort(temArray);
			int maxNum = temArray[nums.length - 1];
			// int maxNumIndex =
			rootNode = new TreeNode(maxNum);

		}
		return rootNode;
	}

	private TreeNode handLeft(int[] leftNums) {
		if (leftNums.length == 1) {
			return new TreeNode(leftNums[0]);
		} else {
			Arrays.sort(leftNums.clone());
		}
		return null;
	}

}
