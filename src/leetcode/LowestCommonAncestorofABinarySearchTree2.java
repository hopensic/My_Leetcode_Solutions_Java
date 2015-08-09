package leetcode;

import tools.P;
import static java.lang.Math.*;

public class LowestCommonAncestorofABinarySearchTree2 {
	int array_a[] = new int[100];
	int array_b[] = new int[100];
	int array_temp[] = new int[100];
	int num = 0;

	public static void main(String[] args) {
		TreeNode a0 = new TreeNode(0);
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(8);
		TreeNode a9 = new TreeNode(9);

		a6.left = a2;
		a6.right = a8;
		a2.left = a0;
		a2.right = a4;
		a8.left = a7;
		a8.right = a9;
		a4.left = a3;
		a4.right = a5;

		TreeNode test =
				new LowestCommonAncestorofABinarySearchTree2()
						.lowestCommonAncestor(a6, a2, a4);
		P.lnrint(test.val);

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (Math.max(p.val, q.val) < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (Math.min(p.val, q.val) > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}

	}

}
