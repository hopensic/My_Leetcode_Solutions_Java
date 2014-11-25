package leetcode;

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(2);
		ListNode t5 = new ListNode(3);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;

		ListNode a = new RemoveDuplicatesfromSortedList().deleteDuplicates(t1);
		System.out.println(1);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode finallist = head;
		ListNode pre = head;
		ListNode temp = head;
		while (head != null && head.next != null) {
			temp = head.next;
			while (temp != null && pre.val == temp.val) {
				temp = temp.next;
			}
			pre.next = temp;
			pre = temp;
			head = temp;
		}
		return finallist;
	}
}
