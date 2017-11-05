package leetcode;

import java.util.LinkedList;

import leetcode.common.tree.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		LinkedList<TreeNode> k1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> k2 = new LinkedList<TreeNode>();
		k1.addFirst(p);
		k2.addFirst(q);
		while (k1.size() > 0) {
			TreeNode tempA = k1.getLast();
			TreeNode tempB = k2.getLast();
			if ((tempA == null && tempB != null)
					|| (tempA != null && tempB == null))
				return false;
			else if (tempA == null && tempB == null) {
				k1.removeLast();
				k2.removeLast();
			} else {
				if (tempA.val != tempB.val)
					return false;
				else {
					k1.removeLast();
					k2.removeLast();
					k1.addFirst(tempA.left);
					k1.addFirst(tempA.right);
					k2.addFirst(tempB.left);
					k2.addFirst(tempB.right);
				}
			}
		}
		return true;
	}
}
