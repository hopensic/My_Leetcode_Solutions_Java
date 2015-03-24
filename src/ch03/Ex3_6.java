package ch03;

import util.list_stack_queue.MyLinkedList;
import util.list_stack_queue.MyLinkedList.Node;

public class Ex3_6 {

	public static void main(String[] args) {
		int N = 5;
		int M = 2;

		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < N; i++)
			list.addLast(i + 1);
		Node<Integer> firstnode = list.getBeginMarker().next;
		Node<Integer> endNode = list.getEndMarker().prev;
		firstnode.prev = endNode;
		endNode.next = firstnode;
		Node<Integer> n = list.getBeginMarker();
		while (list.size() > 1) {
			for (int i = 0; i < 2; i++)
				n = n.next;
			System.out.print(n.getData() + ",");
			list.remove(n);
		}

	}
}
