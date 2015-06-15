package leetcode;

import java.util.LinkedList;

public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t7 = new TreeNode(7);
		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t9 = new TreeNode(9);
		t4.left = t2;
		t4.right = t7;
		t2.left = t1;
		t2.right = t3;
		t7.left = t6;
		t7.right = t9;
		new InvertBinaryTree().invertTree(t4);

	}

	public TreeNode invertTree(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root == null)
			return null;
		list.add(root);
		while (!list.isEmpty()) {
			TreeNode node = list.getLast();
			if (node == null) {
				list.removeLast();
				continue;
			}
			if (node.left != null || node.right != null) {
				TreeNode tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
			list.removeLast();
			list.add(node.left);
			list.add(node.right);
		}
		return root;
	}
}
