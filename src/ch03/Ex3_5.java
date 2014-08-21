package ch03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import util.list_stack_queue.DataUtil;
import util.list_stack_queue.DataUtil.CanBeRepeat;
import util.list_stack_queue.DataUtil.Order;
import util.list_stack_queue.MyArrayList;

public class Ex3_5 {
	public static void main(String[] args) {
		int[] l_array = DataUtil.makeIntArray(7, Order.ASCEND, CanBeRepeat.NO_REPEAT, 15);
		int[] p_array = DataUtil.makeIntArray(10, Order.ASCEND, CanBeRepeat.NO_REPEAT, 30);

		List listL = Arrays.asList(ArrayUtils.toObject(l_array));
		List listP = Arrays.asList(ArrayUtils.toObject(p_array));

		DataUtil.print(listL);
		System.out.println();
		DataUtil.print(listP);
		System.out.println();
		getUnion(listL, listP);

	}

	public static <T extends Comparable<? super T>> void getUnion(List l1, List l2) {
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
			} else if (result > 0) {
				list.add(b);
				b = i2.hasNext() ? i2.next() : null;
			} else {
				list.add(a);
				a = i1.hasNext() ? i1.next() : null;
			}
		}

		if (a == null) {
			list.add(b);
			while (i2.hasNext())
				list.add(i2.next());
		}

		if (b == null) {
			list.add(a);
			while (i1.hasNext())
				list.add(i1.next());
		}

		list.print();

	}
}
