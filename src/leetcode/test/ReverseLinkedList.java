package leetcode.test;

import tools.P;
import leetcode.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode root = n1;
		n1.next = n2;
		n2.next = n3;
		while (n1 != null) {
			P.rint(n1.val);
			P.rint("->");
			n1 = n1.next;
		}
		new ReverseLinkedList().reverse(root);
	}

	void reverse(ListNode root) {

	}

}
