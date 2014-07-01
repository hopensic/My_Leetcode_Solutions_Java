package util.list_stack_queue;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	public MyLinkedList() {
		clear();
	}

	private static class Node<T> {
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}

		public T data;
		public Node<T> prev;
		public Node<T> next;

	}

	private void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	private Node<T> getNode(int idx, int lower, int upper) {
		Node<T> p;
		if (idx < lower || idx > upper)
			throw new IndexOutOfBoundsException();
		if (idx < size() / 2) {
			p = beginMarker.next;
			for (int i = 0; i < idx; i++)
				p = p.next;
		} else {
			p = endMarker;
			for (int i = size(); i > idx; i--)
				p = p.prev;
		}
		return p;
	}

	public int size() {
		return theSize;
	}

	public void clear() {
		beginMarker = new Node<T>(null, null, null);
		endMarker = new Node<T>(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;

}
