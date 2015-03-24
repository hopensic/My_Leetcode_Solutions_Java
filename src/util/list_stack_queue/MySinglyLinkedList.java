package util.list_stack_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import util.list_stack_queue.DataUtil.Order;

public class MySinglyLinkedList<T> implements Iterable<T> {
	private Order order;

	public MySinglyLinkedList(Order order) {
		this.order = order;
		clear();
	}

	public MySinglyLinkedList() {
		this(Order.RANDOM);
	}

	public static class Node<T> {
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}

		public T getData() {
			return this.data;
		}

		public T data;
		public Node<T> next;

	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> current = beginMarker;
		private Node<T> previous = null;
		// private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public T next() {
			// if (modCount != expectedModCount)
			// throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException();
			if (previous == null)
				previous = beginMarker;
			else
				previous = previous.next;
			current = current.next;
			T nextItem = current.data;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			// if (modCount != expectedModCount)
			// throw new ConcurrentModificationException();
			if (!okToRemove)
				throw new IllegalStateException();
			MySinglyLinkedList.this.remove(current, previous);
			okToRemove = false;
		}

	}

	public boolean contains(T x) {
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			if (iterator.next().equals(x))
				return true;
		return false;
	}

	public void addFirstByCheck(T x) {
		if (!contains(x))
			addFirst(x);
	}

	public void addFirst(T x) {
		addAfter(beginMarker, x);
	}

	public void addLast(T x) {
		Node<T> last = getNode(size() - 1);
		addAfter(last, x);
	}

	public void addAfter(Node<T> p, T x) {
		Node<T> newNode = new Node<T>(x, p.next);
		p.next = newNode;
		theSize++;
		modCount++;
	}

	public void removeNode(T x) {
		Iterator<T> iter = this.iterator();
		while (iter.hasNext())
			if (x.equals(iter.next()))
				iter.remove();

	}

	public T removeNodeByIndex(int idx) {
		Node<T> p = getNode(idx);
		Node<T> previousp;
		if (idx < 0 || idx > size() - 1)
			throw new IndexOutOfBoundsException();
		if (idx == 0)
			previousp = beginMarker;
		else
			previousp = getNode(idx - 1);
		return remove(p, previousp);
	}

	public T remove(Node<T> p, Node<T> prev) {
		if (p == prev)
			return null;
		prev.next = p.next;
		theSize--;
		modCount++;
		return p.data;
	}

	public Node<T> getNode(int idx) {
		return getNode(idx, 0, size() - 1);
	}

	public Node<T> getNode(int idx, int lower, int upper) {
		Node<T> p;
		if (idx < lower || idx > upper)
			throw new IndexOutOfBoundsException();
		p = beginMarker.next;
		for (int i = 0; i < idx; i++)
			p = p.next;
		return p;
	}

	public int size() {
		return theSize;
	}

	public void clear() {
		beginMarker = new Node<T>(null, null);
		theSize = 0;
		modCount = 0;
	}

	public void print() {
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + ",");
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	public Node<T> getBeginMarker() {
		return beginMarker;
	}

	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.addFirst(3);
		list.addFirst(2);
		list.addLast(5);
		list.addLast(6);
		list.removeNode(5);
		list.addFirstByCheck(22);
		list.print();

	}
}
