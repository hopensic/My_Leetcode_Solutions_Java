package util.list_stack_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10; // default List size
	private int theSize; // the current size of the List
	private T[] theItems;// the current Items of the List

	public MyArrayList() {
		doClear();
	}

	public void clear() {
		doClear();
	}

	/**
	 * 
	 */
	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void trimToSize() {
		ensureCapacity(size());
	}

	public T get(int idx) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}

	public T set(int idx, T newVal) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		T old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize)
			return;
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++)
			theItems[i] = old[i];
	}

	public boolean add(T x) {
		add(size(), x);
		return true;
	}

	public void add(int idx, T x) {
		if (theItems.length == size())
			ensureCapacity(size() * 2 + 1);
		for (int i = theSize; i > idx; i--)
			theItems[i] = theItems[i - 1];
		theItems[idx] = x;
		theSize++;

	}

	public void addAll(Iterable<? extends T> items) {
		Iterator<? extends T> iter = items.iterator();
		T x;
		while (iter.hasNext()) {
			x = iter.next();
			add(x);
		}
	}

	public void removeAll(Iterable<? extends T> items) {
		Iterator<? extends T> iter = items.iterator();
		T x;
		while (iter.hasNext()) {
			x = iter.next();
			Iterator<T> it = this.iterator();
			while (it.hasNext())
				if (x.equals(it.next()))
					it.remove();
		}

	}

	public T remove(int idx) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		T removedItem = get(idx);
		for (int i = idx; i < theSize - 1; i++)
			theItems[i] = theItems[i + 1];
		theSize--;
		return removedItem;
	}

	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	public void print() {
		Iterator<T> iteraotr = this.iterator();
		while (iteraotr.hasNext())
			System.out.print(iteraotr.next() + ",");
	}

	private class ArrayListIterator implements Iterator<T> {

		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return theItems[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext())
			if (iter.next() == 2)
				iter.remove();
		list.print();
	}

}
