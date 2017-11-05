package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.common.tree.TreeNode;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.right = t2;
		t1.left = t4;
		t2.left = t3;
		t2.right = t5;
		List list = new BinaryTreePreorderTraversal().preorderTraversal(t1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean hasPop = false;
		TreeNode popNode = null;
		while (!stack.empty()) {
			int n = 0;
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				list.add(node.val);
				popNode = stack.pop();
				hasPop = true;
			} else {
				if (node.left == null && node.right != null) {
					if (hasPop) {
						popNode = stack.pop();
						hasPop = true;
					} else {
						list.add(node.val);
						stack.push(node.right);
						hasPop = false;
					}
				}

				if (node.left != null && node.right == null) {
					if (hasPop) {
						popNode = stack.pop();
						hasPop = true;
					} else {
						list.add(node.val);
						stack.push(node.left);
						hasPop = false;
					}
				}

				if (node.left != null && node.right != null) {
					if (hasPop) {
						if (node.left == popNode) {
							stack.push(node.right);
							hasPop = false;
						} else {
							popNode = stack.pop();
							hasPop = true;
						}
					} else {
						list.add(node.val);
						stack.push(node.left);
						hasPop = false;
					}
				}
			}

		}
		return list;
	}
}
