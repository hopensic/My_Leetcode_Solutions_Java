package util.list_stack_queue;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	private static final int DEFAULT_CAPACITY = 10;

	private int theSize;

	private T[] theItems;

	public MyArrayList() {

	}

	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public int size() {
		return theSize;
	}

	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize)
			return;
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++)
			theItems[i] = old[i];
	}

	public Iterator iterator() {
		return null;
	}

}
