package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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
		List list = new BinaryTreeInorderTraversal().inorderTraversal(t1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.empty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode t = stack.pop();
				list.add(t.val);
				p = t.right;
			}

		}
		return list;
	}
}
