package util.list_stack_queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
	public MyLinkedList() {
		clear();
	}

	public static class Node<T> {
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}

		public T data;
		public Node<T> prev;
		public Node<T> next;

	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public T next() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException();
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!okToRemove)
				throw new IllegalStateException();
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
		}

	}

	protected void addFirst(T x) {
		Node<T> firstNode = getNode(0);
		addBefore(firstNode, x);
	}

	protected void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	protected T removeNode(int idx) {
		Node<T> p = getNode(idx);
		return remove(p);
	}

	protected T remove(Node<T> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		return p.data;
	}

	protected Node<T> getNode(int idx) {
		return getNode(idx, 0, size() - 1);
	}

	protected Node<T> getNode(int idx, int lower, int upper) {
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
		return new LinkedListIterator();
	}

	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;

}
