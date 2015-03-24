package util.list_stack_queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
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

		public T getData() {
			return this.data;
		}

		public T data;
		public Node<T> prev;
		public Node<T> next;

	}

	private class LinkedListIterator implements ListIterator<T> {

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

		@Override
		public boolean hasPrevious() {
			return !(current.prev == beginMarker);
		}

		@Override
		public T previous() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!hasPrevious())
				throw new NoSuchElementException();
			current = current.prev;
			T previousItem = current.data;
			okToRemove = true;
			return previousItem;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(T e) {
			current.data = e;
		}

		@Override
		public void add(T e) {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			MyLinkedList.this.addBefore(current, e);
		}

	}
	

	public boolean contains(T x) {
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			if (iterator.next().equals(x))
				return true;
		return false;
	}

	public void addFirst(T x) {
		Node<T> firstNode;
		if (theSize == 0)
			firstNode = endMarker;
		else
			firstNode = getNode(0);
		addBefore(firstNode, x);
	}

	public void addLast(T x) {
		addBefore(endMarker, x);
	}

	public void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<T>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	public T removeNode(int idx) {
		Node<T> p = getNode(idx);
		return remove(p);
	}

	public T remove(Node<T> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
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

	public void print() {
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + ",");
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	public ListIterator<T> listIterator() {
		return new LinkedListIterator();
	}

	public Node<T> getBeginMarker() {
		return beginMarker;
	}

	public Node<T> getEndMarker() {
		return endMarker;
	}

	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.addFirst(2);
		list.addFirst(1);
		list.addLast(3);
//		Iterator<Integer> iter = list.iterator();
//		while (iter.hasNext())
//			if (iter.next() == 2)
//				iter.remove();
//		list.print();
		ListIterator<Integer> iter = list.listIterator();
		list.print();
		System.out.println();
		iter.next();
		iter.add(99);
		System.out.println(iter.next());
		
		
	}
}
