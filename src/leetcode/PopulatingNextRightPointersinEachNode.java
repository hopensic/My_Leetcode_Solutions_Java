package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		t1.right = t2;
		t1.left = t4;
		t2.left = t3;
		t2.right = t5;
		new PopulatingNextRightPointersinEachNode().connect(t1);
		System.out.println(1);

	}

	public void connect(TreeLinkNode root) {
		LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
		if (root != null)
			list.addFirst(root);
		while (list.size() > 0) {
			TreeLinkNode node = list.getLast();
			TreeLinkNode rrnode = node.next == null ? null
					: node.next.left == null ? null : node.next.left;
			if (node.right != null) {
				node.right.next = rrnode;
			}
			if (node.left != null && node.right != null) {
				node.left.next = node.right;
			}
			if (node.left != null)
				list.addFirst(node.left);
			if (node.right != null)
				list.addFirst(node.right);
			list.removeLast();
		}

	}

}
