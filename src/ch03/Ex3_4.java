package ch03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import util.list_stack_queue.DataList;
import util.list_stack_queue.DataList.CanBeSame;
import util.list_stack_queue.DataList.Order;
import util.list_stack_queue.MyArrayList;

public class Ex3_4 {
	public static void main(String[] args) {
		int[] l_array = DataList.makeIntArray(7, Order.ASCEND, CanBeSame.NO_SAME, 15);
		int[] p_array = DataList.makeIntArray(20, Order.ASCEND, CanBeSame.CAN_SAME, 30);

		List listL = Arrays.asList(ArrayUtils.toObject(l_array));
		List listP = Arrays.asList(ArrayUtils.toObject(p_array));

		DataList.print(listL);
		System.out.println();
		DataList.print(listP);
		System.out.println();
		getIntersection(listL, listP);

	}

	public static <T extends Comparable<? super T>> void getIntersection(
			List l1, List l2) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();

		if (l1.size() == 0 || l2.size() == 0)
			throw new IllegalStateException();

		Integer a = i1.next(), b = i2.next();

		while (a != null && b != null) {
			int result = a.compareTo(b);
			if (result == 0) {
				list.add(a);
				a = i1.hasNext() ? i1.next() : null;
				b = i2.hasNext() ? i2.next() : null;
			} else if (result > 0)
				b = i2.hasNext() ? i2.next() : null;
			else
				a = i1.hasNext() ? i1.next() : null;
		}
		list.print();

	}
}
