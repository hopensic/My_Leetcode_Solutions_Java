package leetcode;

import tools.P;

public class ConvertSortedArraytoBinarySearchTree {
	int global[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(a);
		P.lnrint("--------");
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		global = nums;
		if (nums == null || nums.length == 0)
			return null;
		if (nums.length == 1)
			return new TreeNode(nums[0]);
		int len = nums.length;
		int mid = (len - 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		covert(0, mid - 1, root, 1);
		covert(mid + 1, len - 1, root, 0);
		return root;

	}

	private void covert(int left, int right, TreeNode node, int isLeft) {
		if (left > right)
			return;
		int mid = (left + right) / 2;
		if (isLeft == 1)
			node.left = new TreeNode(global[mid]);
		else
			node.right = new TreeNode(global[mid]);

		if (left != right) {
			if (isLeft == 1) {
				covert(left, mid - 1, node.left, 1);
				covert(mid + 1, right, node.left, 0);
			} else {
				covert(left, mid - 1, node.right, 1);
				covert(mid + 1, right, node.right, 0);
			}

		}
	}
}
