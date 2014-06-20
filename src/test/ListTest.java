package test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		init(list);
		print(list);
		removeEvensVer1(list);
		print(list);

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
