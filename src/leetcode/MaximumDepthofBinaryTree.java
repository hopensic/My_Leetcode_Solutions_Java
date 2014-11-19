package leetcode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = 1 + maxDepth(root.left);
		int right = 1 + maxDepth(root.right);
		return (left > right ? left : right);
	}

}
