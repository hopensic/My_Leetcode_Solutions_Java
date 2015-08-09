package leetcode;

import tools.P;

public class LowestCommonAncestorofABinarySearchTree {
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
				new LowestCommonAncestorofABinarySearchTree()
						.lowestCommonAncestor(a6, a2, a4);
		P.lnrint(test.val);

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		find(root, p);
		System.arraycopy(array_temp, 0, array_a, 0, 100);
		clear(array_temp);
		find(root, q);
		System.arraycopy(array_temp, 0, array_b, 0, 100);
		int commonValue = root.val;
		for (int i = 0; i < 100; i++) {
			if (array_a[i] == array_b[i])
				commonValue = array_a[i];
			else
				break;
		}
		TreeNode node = root;
		while (true) {
			int r = node.val;
			if (r == commonValue) {
				return node;
			} else if (commonValue < r) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}

	private void find(TreeNode root, TreeNode needFind) {
		int r = root.val;
		int n = needFind.val;

		if (r == n) {
			array_temp[num++] = n;
			return;
		} else if (n < r) {
			array_temp[num++] = r;
			find(root.left, needFind);
		} else {
			array_temp[num++] = r;
			find(root.right, needFind);
		}
	}

	private void clear(int[] arr) {
		num = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++)
			arr[i] = 0;
	}

}
