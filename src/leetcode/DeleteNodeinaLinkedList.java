package leetcode;

import tools.P;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		a3.next = null;

		new DeleteNodeinaLinkedList().deleteNode(a1);
		P.lnrint(11);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
