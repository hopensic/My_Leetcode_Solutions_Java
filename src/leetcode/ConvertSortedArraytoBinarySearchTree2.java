package leetcode;

import tools.P;

public class ConvertSortedArraytoBinarySearchTree2 {
	int global[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode aa =
				new ConvertSortedArraytoBinarySearchTree2().sortedArrayToBST(a);
		P.lnrint("--------");
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		global = nums;
		if (nums == null || nums.length == 0)
			return null;
		if (nums.length == 1)
			return new TreeNode(nums[0]);
		int len = nums.length;
		return covert(0, len - 1);

	}

	private TreeNode covert(int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(global[mid]);
		node.left = covert(left, mid - 1);
		node.right = covert(mid + 1, right);
		return node;
	}
}
