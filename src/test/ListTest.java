package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		init(list);
		list2.addAll(list);
		list3.addAll(list);
		list4.addAll(list);

		print(list);
		removeEvensVer1(list);
		print(list);

		// print(list2);
		// removeEvensVer2(list2);
		// print(list2);

		print(list3);
		removeEvensVer3(list3);
		print(list3);

		print(list4);
		listIteratorTest(list4);
		print(list4);
	}

	public static void removeEvensVer1(List<Integer> list) {
		int i = 0;
		while (i < list.size()) {
			if (list.get(i) % 2 == 0)
				list.remove(i);
			else
				i++;
		}
	}

	public static void removeEvensVer2(List<Integer> list) {
		for (Integer x : list)
			if (x % 2 == 0)
				list.remove(x);
	}

	public static void removeEvensVer3(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() % 2 == 0)
				iterator.remove();
		}

	}

	public static void listIteratorTest(List<Integer> list) {
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext())
//			if (iterator.next() == 2)
//				iterator.add(999);
		iterator.set(777);
//		iterator.previous();
//		iterator.set(888);
	}

	public static void init(List<Integer> list) {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}

	public static void print(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : list)
			sb.append(i).append(",");
		System.out.println(sb.toString());
	}
}
