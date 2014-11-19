package leetcode;

import java.util.HashMap;

public class LinkedListCycle {

	public static void main(String[] args) {

	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		HashMap<ListNode, ListNode> hashMap = new HashMap<ListNode, ListNode>();
		hashMap.put(head, head);
		while (head.next != null) {
			ListNode node = head.next;
			if (node == hashMap.get(node))
				return true;
			head = node;
			hashMap.put(node, node);
		}
		return false;
	}
}
